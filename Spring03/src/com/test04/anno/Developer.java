package com.test04.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("leess")
public class Developer {

	@Autowired
	@Qualifier("lee")
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
	
	
	@Override
	public String toString() {
		return emp + "\t 개발 (" + dept + ")";
	}
	
	
}
