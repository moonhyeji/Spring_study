package com.test07;

public class samsongTV implements TV {

	
	
	public samsongTV() {
		System.out.println("samsong tv 생성");
	}
	
	
	
	
	
	
	@Override
	public void powerOn() {
		System.out.println("samsong tv powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("samsong tv powerOff");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsong tv volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv volumeDown");
	}

}
