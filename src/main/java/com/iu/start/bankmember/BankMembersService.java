package com.iu.start.bankmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
			}
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO); 
		
	}; 
	//bankmembers 회원가입->insert
	
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception{
		return bankMembersDAO.getSearchById(search);
		
	};
		//검색어 입력, ID 찾기
}
