package com.test02;

public class Address {

	
	private String name;
	private String addr;
	private String phone;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public String toString() {
		return "이름:" +name + "\t주소: " + addr + "\t 전화번호 : " + phone;  
	}
	
}
 

