package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Service
public class MYBoardBizImpl implements MYBoardBiz {

	@Autowired
	private MYBoardDao dao;
	
	
	@Override
	public List<MYBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MYBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MYBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Transactional //해당 메소드에서 transaction처리할 것이다.
	@Override
	public String test() {
		
		dao.insert(new MYBoardDto(0, "transaction", "test", "insert", null));
		
		String test = dao.test();
		test.length();
		
		return test;
	}
	

}
