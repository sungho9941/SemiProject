package com.semi.main.adminNotice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semi.main.board.BoardDTO;
import com.semi.main.board.BoardService;
import com.semi.main.file.FileDTO;
import com.semi.main.util.FileManager;
import com.semi.main.util.Pager;

@Service
public class AdminNoticeService implements BoardService{
	
	@Autowired
	private AdminNoticeDAO adminNoticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	//imgdelete
	public boolean setContentsImgDelete(String path, HttpSession session)throws Exception{
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setFileName(path.substring(path.lastIndexOf("/")+1));
		path = "/resources/upload/board/";
		return fileManager.fileDelete(fileDTO, path, session);
	}
	
	//imgup
	public String setContentsImg(MultipartFile files, HttpSession session) throws Exception{
		
		String path ="/resources/upload/board/";
		String fileName = fileManager.fileSave(path, session, files);
		return path+fileName;
	}
	
	//filedown
	public AdminNoticeFileDTO getFileDown(AdminNoticeFileDTO adminNoticeFileDTO)throws Exception{
		
		return adminNoticeDAO.getFileDetail(adminNoticeFileDTO);
	}
	
	//fileDelete
	public int setFileDelete(AdminNoticeFileDTO adminNoticeFileDTO,HttpSession session)throws Exception{
		String path ="/resources/upload/notice/";
		
		adminNoticeFileDTO = adminNoticeDAO.getFileDetail(adminNoticeFileDTO);
		boolean flag = fileManager.fileDelete(adminNoticeFileDTO, path, session);
		
		if(flag) {
			return adminNoticeDAO.setFileDelete(adminNoticeFileDTO); //de 삭제
		}
		return 0;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.setPerPage(15L);
		pager.makeRowNum();
		Long total = adminNoticeDAO.getTotal(pager);
		pager.makePageNum(total);
		return adminNoticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return adminNoticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		String path = "/resources/upload/notice/";
		int result = adminNoticeDAO.setAdd(boardDTO);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			AdminNoticeFileDTO adminNoticeFileDTO = new AdminNoticeFileDTO();
			adminNoticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			adminNoticeFileDTO.setFileName(fileName);
			adminNoticeFileDTO.setBoardNo(boardDTO.getBoardNo());
			result = adminNoticeDAO.setFileAdd(adminNoticeFileDTO);
			
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		String path = "/resources/upload/notice/";
		
		int result = adminNoticeDAO.setUpdate(boardDTO);
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			AdminNoticeFileDTO adminNoticeFileDTO = new AdminNoticeFileDTO();
			adminNoticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			adminNoticeFileDTO.setFileName(fileName);
			adminNoticeFileDTO.setBoardNo(boardDTO.getBoardNo());
			result = adminNoticeDAO.setFileAdd(adminNoticeFileDTO);
			
		}
		return adminNoticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return adminNoticeDAO.setDelete(boardDTO);
	}
	
	public int setHit(AdminNoticeDTO adminNoticeDTO) throws Exception {
		
		return adminNoticeDAO.setHit(adminNoticeDTO);
	}
	
	
	
	

}
