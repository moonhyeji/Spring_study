package com.test03;

public class Developer extends Emp {

	 private String dept;

	 
	 
	 
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(String name, String salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t 부서: 개발 (" + dept + ")";
	}
	 
	 
}
