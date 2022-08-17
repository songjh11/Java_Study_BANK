package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class BankBookService {

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		int result=0;
		
		return result;
	}
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		int result=0;
			return result;
	}
	

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		int result=0;				
		return result;
	}
	

	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		return ar;
	}
	


	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO bankBookDTO2 = new BankBookDTO(); 		
		return bankBookDTO2;
	}
	
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		int result=0;
		return result;
		
	}
	
}
