package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	//Autowired객체는 Student 타입의 객체가 있으면 applicationContext.xml에서 그 객체를 자동으로 넣어준다.
	//<bean id="lee" class="com.test02.Student">   <-얘.
	@Autowired   
	@Qualifier("lee")      //Qualifier라는 @를 쓰면 lee,hong중에 어느걸 쓸 지 지정해줘서 에러가 안남.
	private Student person;
	
	private int grade;

	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}

	
	
	
	
	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
	

}
