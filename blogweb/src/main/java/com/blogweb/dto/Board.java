package com.blogweb.dto;

import java.io.File;
import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Board {
	private int boardNo;
	private String title;
	private int writer;
	private String name;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private boolean deleted;
	private List<BoardAttach> files;
	private String thumbnail;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public List<BoardAttach> getFiles() {
		return files;
	}
	public void setFiles(List<BoardAttach> files) {
		this.files = files;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
