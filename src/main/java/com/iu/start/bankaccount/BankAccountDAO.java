package com.iu.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpSession;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		Connection connection = DBConnector.getConnection();
		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_seq.NEXTVAL, ?, ?, sysdate)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, accountDTO.getUsername());
		st.setLong(2, accountDTO.getBooknum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, connection);
		return result;
	}
	
}
