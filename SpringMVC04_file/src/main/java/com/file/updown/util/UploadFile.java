package com.file.updown.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String name;
	private String desc;
	private MultipartFile mfile;//mpfile 원래는 
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	
	
}
