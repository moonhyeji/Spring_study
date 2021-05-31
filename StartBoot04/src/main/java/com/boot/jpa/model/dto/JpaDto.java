package com.boot.jpa.model.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity //javax.persistence  의 Entity 
@Table(name="MYBOARD")  	//jpa를 상속받아 구현한 hibernate라는 애가 jpadto 를 가지고 자동으로테이블을 만들어줌.
public class JpaDto {
 
	@Id       //얘가 primary key가 될 것이다.
	@Column  //태이블의 컬럼이다 라고 알려줌. 
	@GeneratedValue(strategy = GenerationType.AUTO)   // 자동으로 시퀀스 만들어주는 애 . 시퀀스 가지고 자동으로 넣어줄 것이다. 라고 설정 
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mytitle;
	
	@Column
	private String mycontent;
	
	@Column(updatable=false)
	@Temporal(TemporalType.DATE) //타입이 날짜 타입이다. 라고 알려줌. 
	private Date mydate;
	// Lombok이란 것을 알아보자 : @ 만으로 모든 것이 다 됨!

	
	
	public JpaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	
	
	
	
	
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	 
	
	
}
