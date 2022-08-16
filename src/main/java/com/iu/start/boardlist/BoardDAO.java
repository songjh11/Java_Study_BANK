package com.iu.start.boardlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.bankbook.BankBookDTO;
import com.iu.start.util.DBConnector;

public class BoardDAO {
	
public ArrayList<BoardDTO>  getList() throws Exception {
	Connection con = DBConnector.getConnection();
	ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
	String sql = "SELECT * FROM BOARD ORDER BY TEXTNUM DESC";
	PreparedStatement st = con.prepareStatement(sql);
	ResultSet rs = st.executeQuery();
	
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTextNum(rs.getInt("TEXTNUM"));
			boardDTO.settName(rs.getString("TNAME"));
			boardDTO.setWriter(rs.getString("WRITER"));
			boardDTO.setwDate(rs.getDate("WDATE"));
			boardDTO.setViewNum(rs.getInt("VIEWNUM"));
			ar.add(boardDTO);
		}
	return ar;
}

public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
//	- 글번호, 글제목, 작성자, 작성날짜, 조회수, 글내용 출력
	Connection con = DBConnector.getConnection();
	BoardDTO boardDTO2 = null;
	String sql = "SELECT * FROM BOARD WHERE TEXTNUM = ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setLong(1, boardDTO.getTextNum());
	ResultSet rs = st.executeQuery();
		if(rs.next()) {
		boardDTO2 = new BoardDTO();
		boardDTO2.setTextNum(rs.getInt("TEXTNUM"));
		boardDTO2.settName(rs.getString("TNAME"));
		boardDTO2.setWriter(rs.getString("WRITER"));
		boardDTO2.setwDate(rs.getDate("WDATE"));
		boardDTO2.setViewNum(rs.getInt("VIEWNUM"));
		boardDTO2.settContents(rs.getString("TCONTENTS"));
					} else {
					return boardDTO2;
				}
	DBConnector.disConnection(rs, st, con);
	return boardDTO2;
}

public int setBoard(BoardDTO boardDTO) throws Exception {
	Connection con = DBConnector.getConnection();
	Calendar cal = Calendar.getInstance();
	String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, BOARD_SEQ.NEXTVAL)";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, boardDTO.gettName());
	st.setString(2, boardDTO.gettContents());
	st.setString(3, boardDTO.getWriter());
	int result = st.executeUpdate();
	DBConnector.disConnection(st, con);
	return result;
}


public int delete(BankBookDTO bankBookDTO) throws Exception{
	Connection con = DBConnector.getConnection();
	String sql = "DELETE BANKBOOK WHERE BOOKNUM = ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setLong(1, bankBookDTO.getBooknum());
	int result = st.executeUpdate();
	DBConnector.disConnection(st, con);
	return result;
}

public int update(BoardDTO boardDTO) throws Exception{
	Connection con = DBConnector.getConnection();
	String sql = "UPDATE BOARD SET TNAME=?, TCONTENTS=? WHERE TEXTNUM=?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, boardDTO.gettName());
	st.setString(2, boardDTO.gettContents());
	st.setInt(3, boardDTO.getTextNum());
	int result = st.executeUpdate();
	return result;
}

}
