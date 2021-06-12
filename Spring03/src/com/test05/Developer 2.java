package com.test05;

public class Developer {

	private Emp emp;
	private String dept;
	
	
	public Developer() {
		super();
	}
	
	
	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	

	public String s() {
		// return "Developer [emp=" + emp + ", dept=" + dept + "]";
		return emp + "\t 개발 (" + dept + ")";
	}
	
}
