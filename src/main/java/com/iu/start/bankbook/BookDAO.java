package com.iu.start.bankbook;

import java.util.ArrayList;

public interface BookDAO {

	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;
	//bankbook 테이블에 insert
	//booknum; 일련번호, 밀리세컨즈 활용
	// String bookname;//계좌명
	// double bookrate;//이자율
	// int booksale;//판매가능여부, 1로 입력, 1이면 판매 가능, 0이면 판매 중지
	
	public ArrayList<BankBookDTO> getList() throws Exception;
	//bankbook 모든 데이터를 최신순으로 조회
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;
	//bankbook의 booksale컬럼 변경 및 업데이트
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
	//booknum의 값으로 검색하고 해당 내용만 조회
}

