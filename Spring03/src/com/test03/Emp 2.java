package com.test03;

public class Emp {
	
	private String name;
	private String salary;
	
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Emp(String name, String salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "이름:" + name + "\t 월급 : " + salary;
	}
	
	
}
