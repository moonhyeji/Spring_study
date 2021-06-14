package com.file.updown.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class FileValidator implements Validator {
//파일 검증 
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {  //validator 사용 가능 여부 확인 
		return false;
	}

	@Override            //검증의 대상          에러 객체 
	public void validate(Object target, Errors errors) {
      
		UploadFile file = (UploadFile) target; //대상을 파일에 등록하고,
       
       if(file.getMfile().getSize() == 0) { // mfile이 사이즈가 0일경우 
    	      //*필드에 대한 error 코드를 리턴./ error code가 없으면 default message 전달 
    	   errors.rejectValue("mfile", "fileNPE", "Please select a file");  // 실행됨.
    	                   // 필드값, 에러코드, 에러코드에 대한 메세지 
    	   				   // 필드에 대한 에러코드 추가, 에러코드에 대한 메세지 
       }
	}

}
























