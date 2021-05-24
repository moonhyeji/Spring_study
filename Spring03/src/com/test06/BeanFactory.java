package com.test06;

public class BeanFactory {

	
	//bean 실행 시 이런 형태로 실행돼서 리턴된다.
	Object getBean(String name) { // getBean("lg");
		
		if(name.equals("samsong")) {
			return new SamsongTv();
			
		}else if(name.equals("lg")) { //getBean("lg"); 일 경우 실행 
			return new LgTV();  // LgTV 오브젝트가 리턴된다.
		//MTest의   TV lg = new LgTV(); 형태로 가게 됨. 
		
		}
		
		return null;
	}
}
