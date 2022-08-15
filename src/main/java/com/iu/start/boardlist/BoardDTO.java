package com.iu.start.boardlist;

import java.sql.Date;

public class BoardDTO {
	
    private int textNum;
    private String tName;
    private String tContents;
    private String writer;
    private Date wDate;
    private int viewNum;
    
    public int getTextNum() {
		return textNum;
	}
	public void setTextNum(int textNum) {
		this.textNum = textNum;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettContents() {
		return tContents;
	}
	public void settContents(String tContents) {
		this.tContents = tContents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	

}
