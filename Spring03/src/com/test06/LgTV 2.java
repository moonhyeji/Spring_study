package com.test06;

public class LgTV implements TV {

	@Override
	public void powerOn() {
        System.out.println("lg tv poweron");
	}

	@Override
	public void powerDown() {
		System.out.println("lg tv powerDown");
	}

	@Override
	public void volumeup() {
		System.out.println("lg tv volumeup");
	}

	@Override
	public void volumeDown() {
		System.out.println("lg tv volumeDown");
	}

}
