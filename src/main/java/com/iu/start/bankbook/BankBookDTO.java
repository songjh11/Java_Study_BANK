package com.iu.start.bankbook;

public class BankBookDTO {

	private Long bookNum;//일련번호, 밀리세컨즈 활용
	private String bookName;//계좌명
	private Double bookRate;//이자율
	private Integer bookSale;//판매가능여부, 1로 입력
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	
	
	
}
