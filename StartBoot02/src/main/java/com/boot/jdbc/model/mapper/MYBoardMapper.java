package com.boot.jdbc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.jdbc.mode.dto.MYDto;

//mybatis를 인터페이스로 사용하기 
@Mapper
public interface MYBoardMapper {

	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD ORDER BY MYNO DESC ")
	List<MYDto> selectList();
	
	
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD WHERE MYNO = #{myno}")
	MYDto selectOne(int myno);
	
	@Insert(" INSERT INTO MYBOARD VALUES(MYNOSEQ.NEXTVAL, #{myname}, #{mytitle}, #{mycontent}, SYSDATE) ")
	int insert(MYDto dto);
	
	
	@Update("UPDATE MYBOARD SET MYTITLE = #{mytitle}, MYCONTENT=#{ mycontent} WHERE MYNO =#{myno} ")
	int updaet(MYDto dto);
	
	@Delete(" DELETE FROM MYBOARD WHERE MYNO = #{myno}")
	int delete(int myno);
	
	
}
