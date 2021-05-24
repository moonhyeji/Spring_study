package com.test07;

public class LgTV implements TV {

	
	public LgTV() {
		System.out.println("Lg tv 생성! ");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("Lg tv powerOn! ");

	}

	@Override
	public void powerOff() {
		System.out.println("Lg tv powerOff! ");

	}

	@Override
	public void volumeUp() {
		System.out.println("Lg tv volumeUp! ");

	}

	@Override
	public void volumeDown() {
		System.out.println("Lg tv volumeDown! ");

	}

}
