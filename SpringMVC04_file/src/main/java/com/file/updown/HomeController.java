package com.file.updown;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.file.updown.util.FileValidator;
import com.file.updown.util.UploadFile;

import java.io.*;
@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")	
	public String uploadForm() {
		return "upload";  //upload.jsp
	
	
	}
	
	@RequestMapping("/upload")
	public String fileupload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
								//타겟(파일의정보) , 에러  
		fileValidator.validate(uploadFile, result); // 에러가 있다면 에러를 알려줌. //에러가 있다면 resul는 이미 에러가 등록되어 잇는 상태 (filevalidator.java)에서 에러를 등록 
		
		if(result.hasErrors()) { //에러가 있다면 (파일의 크기가 0 이라면 )
			
		return "upload"; //upload.jsp 로 돌아가기 
	}
		
		
	MultipartFile file = uploadFile.getMfile(); //업로드파일의 mfile 
	String name = file.getOriginalFilename();  //client의 파일시스템에서의 파일네임 : 팬케이크맛쿠키 
	
	UploadFile fileObj = new UploadFile();
	fileObj.setName(name);
	fileObj.setDesc(uploadFile.getDesc());

	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	
	try {
		inputStream = file.getInputStream();
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
	    System.out.println("업로드 될 실제 경로 "+ path);
	    
	    //여기부터 
	   File storage = new File(path); //패스 경로만 가져와서 이 경로에 
	   if(!storage.exists()) { //경로상의 폴더 유무 체크 - ! 없다면,
		   storage.mkdirs();  // 폴더 만들어라 
	   }
	   
	   File newFile = new File(path + "/" + name); //패스경로/팬케이크맛쿠키 으로 newFile 만든다.
	   if(!newFile.exists()) {  //경로상의 파일 유무 -없다면  
		   newFile.createNewFile();   //파일 만들어라 
	   }
	   
	   
	   outputStream = new FileOutputStream(newFile);
	   int read = 0;
	   byte[] b = new byte[(int)file.getSize()];  //업로드된 파일의 사이즈를 가져와서 
	   //getsize (long) -> int 로바꿔서 byte의 배열 안에넣는다.
	   
	   
	   
	   
	   while((read = inputStream.read(b)) != -1){   //buffer가 일정량을 순차적으로 보냄  //stream의 끝에 도달해서 더 이상 보낼 데이터가 없으면 -1 리턴 
		   outputStream.write(b, 0, read); // 이 outputstream 에 b로부터 데이터를 가져와서 넣어줌 
		     //            (바이트배열인 b부터 씀, 데이터의 시작점 , 넣을(사용할) 데이터의 수)
	   }
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	model.addAttribute("fileObj", fileObj);
	
	
	 return "download";
	}
	

	@RequestMapping("/download")
	@ResponseBody 
	public byte[] fileDownload(HttpServletRequest request,HttpServletResponse response, String name) {
		byte[] down = null;
		
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(),"/resources/storage");
			File file = new File(path + "/" + name);
			
			down = FileCopyUtils.copyToByteArray(file);
			
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			response.setHeader("Content-Disposition","attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return down;
	
   }
}












