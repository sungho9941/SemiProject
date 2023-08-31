package com.semi.main.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.semi.main.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String getList(Pager pager,Model model,Long catNo) throws Exception{
		System.out.println("컨트롤러 startRow: " + pager.getStartRow()); // 확인용 출력
		 System.out.println("catNo: " + catNo); // 확인용 출력
		List<ProductDTO> ar = productService.getList(pager);
		
		// 각 상품에 대한 이미지 리스트 가져오기
        for (ProductDTO product : ar) {
            List<ProductFileDTO> fileList = productService.getFileList(product.getProNo());
            if (!fileList.isEmpty()) { // 파일이 있는 경우에만 첫 번째 파일을 설정
                ProductFileDTO firstFile = fileList.get(0);
                product.getFileDTOs().clear(); // 기존 파일 리스트 제거
                product.getFileDTOs().add(firstFile); // 첫 번째 파일만 추가
            }
        }
		model.addAttribute("list",ar);
		model.addAttribute("pager", pager);
		
		return "product/list";
	}
	
	
	
		@RequestMapping(value = "categoryList")
		public String getCategoryList(Pager pager,Long catNo, Model model) throws Exception{
		 System.out.println("컨트롤러 startRow: " + pager.getStartRow()); // 확인용 출력
		 System.out.println("catNo: " + catNo); // 확인용 출력
	        pager.setCatNo(catNo); // 카테고리 번호를 Pager에 설정
	        List<ProductDTO> ar = productService.getCategoryList(pager);
	        // 각 상품에 대한 이미지 리스트 가져오기
	        for (ProductDTO product : ar) {
	            List<ProductFileDTO> fileList = productService.getFileList(product.getProNo());
	            if (!fileList.isEmpty()) { // 파일이 있는 경우에만 첫 번째 파일을 설정
	                ProductFileDTO firstFile = fileList.get(0);
	                product.getFileDTOs().clear(); // 기존 파일 리스트 제거
	                product.getFileDTOs().add(firstFile); // 첫 번째 파일만 추가
	            }
	        }
			model.addAttribute("list",ar);
			model.addAttribute("pager", pager);
			model.addAttribute("catNo", catNo);
	        return "product/categoryList"; // JSP page name in the "product" folder
	    }
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "product/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(ProductDTO productDTO, MultipartFile[] photos, HttpSession session, Model model)throws Exception{
		int result = productService.setAdd(productDTO, photos, session);
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
			
		}
		
		model.addAttribute("message", message);
		model.addAttribute("url", "/");
		
		return "commons/result";
	}
	
}
