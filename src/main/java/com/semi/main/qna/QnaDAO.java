package com.semi.main.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.main.adminNotice.AdminNoticeFileDTO;
import com.semi.main.board.BoardDAO;
import com.semi.main.board.BoardDTO;
import com.semi.main.qnaComment.QnaCommentDTO;
import com.semi.main.util.Pager;

@Repository 
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	final private String NAMESPACE= "com.semi.main.qna.QnaDAO.";
	
	public List<QnaCommentDTO> getCommentList(QnaCommentDTO qnaCommentDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", qnaCommentDTO);
	}
	//qnacommetadd
	public int setCommentAdd(QnaCommentDTO qnaCommentDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setCommentAdd", qnaCommentDTO);
	}
	
	public List<BoardDTO> getMyList(QnaDTO qnaDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMyList",qnaDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	
	public int setFileAdd(QnaFileDTO qnaFileDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setFileAdd", qnaFileDTO);
	
	}
	
	//filedown
	public QnaFileDTO getFileDetail(QnaFileDTO qnaFileDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getFileDetail",qnaFileDTO);
	}
	
	//fileDelete
	public int setFileDelete(QnaFileDTO qnaFileDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setFileDelete",qnaFileDTO);
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setAdd",boardDTO);
	}
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	@Override
	public Long getTotal(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	//statusupdate
	public int setStatusUpdate(QnaDTO qnaDTO)throws Exception{
		
		return sqlSession.update(NAMESPACE+"setStatusUpdate", qnaDTO);
				
	}


	
	

}
