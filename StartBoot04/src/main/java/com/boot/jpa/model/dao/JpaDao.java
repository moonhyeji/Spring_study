package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.dto.JpaDto;


public interface JpaDao extends JpaRepository<JpaDto, Integer> {
	// T: 테이블의 타입 
	//ID:id로 지정해준 애.primarykey 로 지정해준 애의 타입. myno의 타입  

	
	public List<JpaDto> findAll(Sort sort);
	
	public JpaDto findByMyno(int myno);
	
	public JpaDto save(JpaDto dto); 
	
	public JpaDto saveAndFlush(JpaDto dto);  //Flush : db에 commit 하는 용도 
	
	@Transactional
	public void deleteByMyno(int myno);
	
	
}
