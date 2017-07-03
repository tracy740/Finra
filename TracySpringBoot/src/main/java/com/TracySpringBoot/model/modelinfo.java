package com.TracySpringBoot.model;
import javax.persistence.Id;

import java.util.Collection;

import javax.persistence.Entity;



@Entity
public class modelinfo {
	@Id
	private Integer fileid;
	private String filename;
	private Long filesize;
	private String filepath;
	
	public modelinfo() {
		super();
	}
	
	
	public void setId(Integer id) {
		this.fileid = id;
	}
	public String getName() {
		return filename;
	}
	public void setName(String name) {
		this.filename = name;
	}
	public Long getSize() {
		return filesize;
	}
	public void setSize(Long size) {
		this.filesize = size;
	}
	
	public String getPath() {
		return filepath;
	}
	public void setPath(String path) {
		this.filepath = path;
	}
	public modelinfo(Integer id, String name, Long size,  String path) {
		super();
		this.fileid = id;
		this.filename = name;
		this.filesize = size;
		this.filepath = path;
	}
	@Override
	public String toString() {
		return "FileInfo: [id=" + fileid + ", name=" + filename + ", size=" + filesize + " Bytes]";
	}
	
}
