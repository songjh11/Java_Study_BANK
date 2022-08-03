package com.iu.start.bankbook;

public class BankBookDTO {

	private Long booknum;//일련번호, 밀리세컨즈 활용
	private String bookname;//계좌명
	private Double bookrate;//이자율
	private Integer booksale;//판매가능여부, 1로 입력
	
	public Long getBooknum() {
		return booknum;
	}
	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Double getBookrate() {
		return bookrate;
	}
	public void setBookrate(Double bookrate) {
		this.bookrate = bookrate;
	}
	public Integer getBooksale() {
		return booksale;
	}
	public void setBooksale(Integer booksale) {
		this.booksale = booksale;
	}
    
}
