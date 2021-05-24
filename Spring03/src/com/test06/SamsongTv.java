package com.test06;

public class SamsongTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsong tv power on");
	}

	@Override
	public void powerDown() {
		System.out.println("samsong tv powerDown");
	}

	@Override
	public void volumeup() {
        System.out.println("samsong tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv volume down");
	}

}
