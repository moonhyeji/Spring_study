package com.test04.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("honggd")
public class Engineer {

	
	@Autowired
	@Qualifier("hong")
	private Emp emp;
	private String dept;
	
	
	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp + "\t 기술 ( " + dept + ")";
	}
	
}
