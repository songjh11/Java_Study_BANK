package com.iu.start.bankmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		Connection con =DBConnector.getConnection();
		String sql = "SELECT USERNAME, NAME FROM BANKMEMBERS WHERE USERNAME=? AND PASSWORD=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		} else {
			bankMembersDTO = null;
		}
		DBConnector.disConnection(rs, st, con);
		
	return bankMembersDTO;
	}
	
		
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		int rs = st.executeUpdate();
			
		DBConnector.disConnection(st, con);
				
		return rs;
	}
	
	@Override
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception {
		Connection con = DBConnector.getConnection();
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
			while(rs.next()) {
				BankMembersDTO bankMembersDTO = new BankMembersDTO();
				bankMembersDTO.setUsername(rs.getString("username"));
				bankMembersDTO.setPassword(rs.getString("password"));
				bankMembersDTO.setName(rs.getString("name"));
				bankMembersDTO.setEmail(rs.getString("email"));
				bankMembersDTO.setPhone(rs.getString("phone"));
			    ar.add(bankMembersDTO);	
		}
				
		DBConnector.disConnection(rs, st, con);
		
		return ar;
	}

}
