package com.iu.start.bankmember;

import java.util.List;

public interface MembersDAO {
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception; 
	//bankmembers 회원가입->insert
	
	public List<BankMembersDTO> getSearchById(String search) throws Exception;
		//검색어 입력, ID 찾기
	
}
