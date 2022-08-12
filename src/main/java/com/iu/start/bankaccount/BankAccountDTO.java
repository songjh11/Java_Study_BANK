package com.iu.start.bankaccount;

import java.sql.Date;

public class BankAccountDTO {

	private int accountnum;
	private String username;
	private long booknum;
	private Date accountdate;
	
	
	public int getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getBooknum() {
		return booknum;
	}
	public void setBooknum(long booknum) {
		this.booknum = booknum;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	
	
}
