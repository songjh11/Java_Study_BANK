package com.iu.start.bankmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO {
		
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassward());
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
				bankMembersDTO.setPassward(rs.getString("password"));
				bankMembersDTO.setName(rs.getString("name"));
				bankMembersDTO.setEmail(rs.getString("email"));
				bankMembersDTO.setPhone(rs.getString("phone"));
			    ar.add(bankMembersDTO);	
		}
				
		DBConnector.disConnection(rs, st, con);
		
		return ar;
	}

}
