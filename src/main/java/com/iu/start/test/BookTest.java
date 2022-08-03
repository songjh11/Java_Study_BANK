package com.iu.start.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Scanner sc = new Scanner(System.in);
		
		try {
			Calendar cal = Calendar.getInstance();
			bankBookDTO.setBooknum((long)(cal.getTimeInMillis()));
			System.out.println("계좌명을 입력하세요");
			bankBookDTO.setBookname(sc.next());
			System.out.println("이자율을 입력하세요");
			bankBookDTO.setBookrate(sc.nextDouble());
			bankBookDTO.setBooksale(1);
			int result = bankBookDAO.setBankBook(bankBookDTO);
			if(result>0) {
				System.out.println("계좌를 개설하였습니다");
			} 
			System.out.println("================================");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("계좌 개설 실패");
			System.out.println("================================");
		}
		
		try {
			ar = bankBookDAO.getList();
			if(ar.size()>0) {
				System.out.println("통장 개설 목록 출력");
				for(BankBookDTO b: ar) {
					System.out.println("BOOKNUM: "+b.getBooknum());
					System.out.println("BOOKNAME: "+b.getBookname());
					System.out.println("BOOKRATE: "+b.getBookrate());
					System.out.println("BOOKSALE: "+b.getBooksale());
					System.out.println("================================");
				}
				System.out.println("================================");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			try {
				System.out.println("변경 실행");
				System.out.println("인덱스 번호를 입력하세요");
				bankBookDTO = ar.get(sc.nextInt());
				
				int result = bankBookDAO.setChangeSale(bankBookDTO);
				if(result>0) {
					System.out.println("판매 여부 변경 완료");
					System.out.println("================================");
				}
			} catch (Exception e1) {
				System.out.println("변경 실패");
				System.out.println("================================");
				e1.printStackTrace();
			}
		
		
		try {
			System.out.println("검색 실행");			
			System.out.println("인덱스 번호를 입력하세요");
			bankBookDTO = ar.get(sc.nextInt());
			
			BankBookDTO bankBookDTO2 = bankBookDAO.getDetail(bankBookDTO);
			
			if(bankBookDTO2==null) {
				System.out.println("검색 실패");
			} else {
			System.out.println("BOOKNUM: "+bankBookDTO2.getBooknum());
			System.out.println("BOOKNAME: "+bankBookDTO2.getBookname());
			System.out.println("BOOKRATE: "+bankBookDTO2.getBookrate());
			System.out.println("BOOKSALE: "+bankBookDTO2.getBooksale());
			
		}} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
