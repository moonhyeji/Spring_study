package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickNamePrn {

	
	@Autowired    //NickName 타입의 객체에 값이 있으면 nickName에 자동으로 (injection)넣어주겠다.  
	private NickName nickName;

	
	
	
	
	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "내 별명 : " + nickName;
	}
	
	
}
