package com.test02;

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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Emp [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
