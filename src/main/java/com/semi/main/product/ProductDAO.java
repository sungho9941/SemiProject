package com.semi.main.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.main.util.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.semi.main.product.ProductDAO.";
	
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}


	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		System.out.println(productDTO.getProNo());
		productDTO= sqlSession.selectOne(NAMESPACE+"getDetail", productDTO);
		System.out.println(productDTO);
		return productDTO;
	}
	
}
