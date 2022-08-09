package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO {
	
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		//bankbook 테이블에 insert
		//booknum; 일련번호, 밀리세컨즈 활용
		// String bookname;//계좌명
		// double bookrate;//이자율
		// int booksale;//판매가능여부, 1로 입력, 1이면 판매 가능, 0이면 판매 중지
		Connection con = DBConnector.getConnection();
		Calendar cal = Calendar.getInstance();
		
		String sql = "INSERT INTO BANKBOOK VALUES (?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, cal.getTimeInMillis());
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setInt(4, 1);
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		//bankbook의 booksale컬럼 변경 및 업데이트
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("일련번호 입력");
		if(bankBookDTO.getBooksale()==1) {
		st.setInt(1, 0);
		st.setLong(2, sc.nextLong());
		result = st.executeUpdate();
		result=0;
		}
		else {
			st.setInt(1, 1);
			st.setLong(2, sc.nextLong());
			result = st.executeUpdate();
			result=1;
		}
				
		return result;
	}
	
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		//bankbook 모든 데이터를 최신순으로 조회
		Connection con = DBConnector.getConnection();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBooknum(rs.getLong("BOOKNUM"));
				bankBookDTO.setBookname(rs.getString("BOOKNAME"));
				bankBookDTO.setBookrate(rs.getDouble("BOOKRATE"));
				bankBookDTO.setBooksale(rs.getInt("BOOKSALE"));
				ar.add(bankBookDTO);
			}
			
		return ar;
	}
	

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		//booknum의 값으로 검색하고 해당 내용만 조회
		Connection con = DBConnector.getConnection();
		BankBookDTO bankBookDTO2 = null;
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
//		Scanner sc = new Scanner(System.in);
//		System.out.println("일련번호 입력");
		st.setLong(1, bankBookDTO.getBooknum());
		ResultSet rs = st.executeQuery();
			if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBooksale(rs.getInt("BOOKSALE"));
					} else {
						return bankBookDTO2;
					}
				
		DBConnector.disConnection(rs, st, con);
		return bankBookDTO2;
	}
}
