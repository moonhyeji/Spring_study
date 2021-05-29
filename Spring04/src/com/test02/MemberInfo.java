package com.test02;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
/*
 * <메세지 국제화> (한국어, 영어, 중국어 등...)여러개의 데이터를 properties로 저장해놓고 가져와서 쓸 때 사용됨. 
 * MessageSourceAware는 번들이 지정된 properties 파일을 setMessageSource로 전달 
 * 
 * ResourceBundleMessageSource의 setBaseName()을 통해 전달된 파일을 setMessageSource로 자동 매핑
 * ResourceBundleMessageSource와 MessageSourceAware는 쌍으로 사용
 */
public class MemberInfo implements MessageSourceAware {

	
	private MessageSource message;
	
	
	//ResourceBundleMessageSource가 testmessage_en.property, testmessage_ko.property  를 읽어서
	//messageSource 로 전달해줌 
	@Override
	public void setMessageSource(MessageSource messageSource) {  
        System.out.println("컨테이너가 메세지 설정을 수행중...");
        this.message= messageSource;
	}
	
	//전달받은 properties들의 값을 가지고 와서 .
	public void display(Locale locale) {  
		String name = message.getMessage("member.name", null, locale);
		String birthplace = message.getMessage("member.birthplace",null, locale);
		String hobby = message.getMessage("member.hobby", null, locale);
		String age = message.getMessage("member.age", new Object[] {"13"}, locale);
		
		//출력해준다.
		System.out.println(locale);  
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
	}

}
















