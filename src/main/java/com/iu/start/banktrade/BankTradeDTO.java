package com.iu.start.banktrade;

import java.sql.Date;

public class BankTradeDTO {
	
	private int tradenum;
	private int tradeamount;
	private Date tradedate;
	private int tradebalance;
	private int tradeio;
	private int accountnum;
	
	public int getTradenum() {
		return tradenum;
	}
	public void setTradenum(int tradenum) {
		this.tradenum = tradenum;
	}
	public int getTradeamount() {
		return tradeamount;
	}
	public void setTradeamount(int tradeamount) {
		this.tradeamount = tradeamount;
	}
	public Date getTradedate() {
		return tradedate;
	}
	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}
	public int getTradebalance() {
		return tradebalance;
	}
	public void setTradebalance(int tradebalance) {
		this.tradebalance = tradebalance;
	}
	public int getTradeio() {
		return tradeio;
	}
	public void setTradeio(int tradeio) {
		this.tradeio = tradeio;
	}
	public int getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}

}
