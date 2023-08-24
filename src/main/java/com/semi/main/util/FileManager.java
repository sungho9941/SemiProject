package com.semi.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.semi.main.file.FileDTO;

@Component
public class FileManager extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("fileManager");
		String b = (String)model.get("board");
		System.out.println(b);
		FileDTO fileDTO = (FileDTO)model.get("file");
		System.out.println(fileDTO.getFileName());
		
//		1.파일 경로 준비
		String path = "/resources/upload/" + b;
		path = request.getSession().getServletContext().getRealPath(path);
		
//		2. File 객체 생성
		File file = new File(path, fileDTO.getFileName());
		
//		3. 파일의 크기 설정
		response.setContentLength((int)file.length());
		
//		4. 다운로드 이름 인코딩
		String downName = fileDTO.getOriginalFileName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
//		5. header 정보
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
//		6. 전송
		FileInputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(is, os);
		
//		7. 자원 해제
		os.close();
		is.close();
	}
	
	//fileDelete
	public boolean fileDelete(FileDTO fileDTO, String path, HttpSession session) {
		//1. 삭제할 폴더의 실제 경로
		path = session.getServletContext().getRealPath(path);
		
		File file = new File(path, fileDTO.getFileName());
		
		return file.delete();
	}
	
	//fileSave
	public String fileSave(String path, HttpSession session, MultipartFile multipartFile) throws Exception {
		

		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String uId = UUID.randomUUID().toString();
		uId = uId+"_"+multipartFile.getOriginalFilename();
		System.out.println(uId);
		file = new File(file, uId);
		
		multipartFile.transferTo(file);
		
		return uId;
	}




	
	
}
