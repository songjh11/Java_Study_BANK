package com.iu.start.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.bankmember.BankMembersDAO;
import com.iu.start.bankmember.BankMembersDTO;

public class MemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		Scanner sc = new Scanner(System.in);
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		ArrayList<BankMembersDTO> ar = new ArrayList();
		
//		bankMembersDTO.setUsername("user890");
//		bankMembersDTO.setPassward("12345");
//		bankMembersDTO.setName("name890");
//		bankMembersDTO.setEmail("890890@naver.com");
//		bankMembersDTO.setPhone("010-7940-5612");
//				
//		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			if(result != 0) {
//				System.out.println("회원 가입 성공");
//			} 			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("회원 가입 실패");
//			e.printStackTrace();
//		}
//		
		try {
			System.out.println("검색어를 입력하세요");
			String search = sc.next();
			
			ar = bankMembersDAO.getSearchById(search);
				for(BankMembersDTO b: ar) {
				System.out.println("USERNAME: "+b.getUsername());
				System.out.println("PASSWORD: "+b.getPassward());
				System.out.println("NAME: "+b.getName());
				System.out.println("EMAIL: "+b.getEmail());
				System.out.println("PHONE: "+b.getPhone());
					}
				if(ar.size()==0) {
					System.out.println("검색 실패");
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
