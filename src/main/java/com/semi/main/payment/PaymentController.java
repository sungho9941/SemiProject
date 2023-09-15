package com.semi.main.payment;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.main.member.MemberDTO;
import com.semi.main.product.ProductDTO;
import com.semi.main.product.ProductService;
import com.semi.main.util.PayService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {
  
	private final String REST_API_KEY = "0423121332258201";
	private final String REST_API_SECRET = "gucymO3pfPTz2um1RFankOgQlBdMynAnTuxxjh8mXDFLYhLjcC5XZjhZ1UD39Dgpv0aFfphzsR1RYlvK";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PayService payService;
	

	@RequestMapping(value = "paymentadd", method = RequestMethod.GET)
	public String paymentAdd(ProductDTO productDTO, Model model) throws Exception{
		productDTO = productService.getDetail(productDTO);
		System.out.println(productDTO.getProName());
		model.addAttribute("dto", productDTO);
		return "payment/paymentadd";
	}
	
		
	@ResponseBody
	@RequestMapping(value="paymentadd", method = RequestMethod.POST)
	public int paymentAdd(@RequestBody PaymentDTO paymentDTO) throws Exception
	{	
			System.out.println("결제2");
			PayService payService = new PayService();
			String token = payService.getToken(REST_API_KEY, REST_API_SECRET);
			Map<String, String> paymentInfo = payService.paymentInfo(token, paymentDTO.getUidNo());
			
			String amount = paymentInfo.get("amount"); // 결제된 금액
			
			int result=0;
			if(Integer.parseInt(amount) == paymentDTO.getTotalPrice()) { // 검증 성공
				System.out.println("검증 성공!");
				result = paymentService.paymentAdd(paymentDTO);
				
			}else { // 검증 실패(결제된 금액과 실제 계산되어야 할 금액이 다른 경우)
				// 취소 처리
				System.out.println("검증 실패");
				result = payService.paymentCancel(token, paymentDTO.getUidNo(), amount, "결제금액 오류");
				
				return result;
			}
			
			return result;
	}
	

	@RequestMapping(value="cancel", method = RequestMethod.POST)
	public String paymentDelete(PaymentDTO paymentDTO) throws Exception
	{
		
		PayService payService = new PayService();
		String token = payService.getToken(REST_API_KEY, REST_API_SECRET);
		
		Map<String, String> paymentInfo = payService.paymentInfo(token,paymentDTO.getUidNo());
		
		String amount = paymentInfo.get("amount");
		
		int result=payService.paymentCancel(token,paymentDTO.getUidNo() , amount, paymentDTO.getReason());
	
		
		System.out.println("result:"+result);
		if( result > 0 ) {
			
			paymentService.setPayUpdate(paymentDTO);
		}
		return "commons/ajaxResult";
	
	}

	//계좌 확인후 db 저장
	 @RequestMapping(value = "checkaccount", method = RequestMethod.POST)
	   public String checkAccount(MemberDTO memberDTO, Model model)throws Exception{
		  System.out.println(memberDTO.getHolder());
		  System.out.println(memberDTO.getBankCode());
		  System.out.println(memberDTO.getBankNum());
	      String token = payService.getToken(REST_API_KEY, REST_API_SECRET);
	      String name = payService.checkAccount(token, memberDTO.getBankCode(), memberDTO.getBankNum());
	      System.out.println(name);
	      
	      int result = 0;
	      if(memberDTO.getHolder().equals(name)) {
	    	  System.out.println("예금주 확인 완료");
	    	  //db저장
	    	  result = paymentService.checkAccount(memberDTO);
	    	  
	      }else {
	    	  System.out.println("예금주가 다릅니다.");
	    	  result = 0;
	      }
	      
	      System.out.println(result);
	      model.addAttribute("result", result);
	      return "commons/ajaxResult";
	   }
	 
	    @GetMapping("bankadd")
	    public String bankAdd(MemberDTO memberDTO, Model model) {
	       model.addAttribute("dto", memberDTO);
	       return "payment/bankadd";
	    }

}
