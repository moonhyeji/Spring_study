package com.test03;

import org.springframework.stereotype.Component;


                      //id는 첫글자는 소문자, 나머지 똑같이 
@Component //= ( <bean id="lgTV" class="com.test03.lgTv"/>  ) 컴포넌트@의 지정이 없을 경우,이렇게 하겠다 라는 뜻. 
public class LgTV implements TV {

	@Override
	public void powerOn() {
			System.out.println("lg tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg tv power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("lg tv volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("lg tv volume down");

	}

}
