package com.blogweb.dto;

import java.io.File;
import java.sql.Date;
import java.util.List;

public class Board {
	private int boardNo;
	private String title;
	private int writer;
	private String content;
	private Date regDate;
	private boolean deleted;
	private List<BoardAttach> files;
	
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
}
