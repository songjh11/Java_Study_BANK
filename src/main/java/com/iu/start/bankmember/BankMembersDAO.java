package com.iu.start.bankmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankmember.BankMembersDAO.";
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
	return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
		
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
	return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	@Override
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
			return sqlSession.selectList(NAMESPACE+"getSearchById", search);
	}

}
