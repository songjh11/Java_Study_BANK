package com.iu.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "/bankbook/")
public class BankBookController {

	// /bankbook/list Get list
	// /bankbook/detail Get detail
	
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println("List");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		request.setAttribute("list", ar);
		return "/bankbook/list";
	}
	
	@RequestMapping (value = "detail", method = RequestMethod.GET)
	public String getDetail(Long booknum, HttpServletRequest request) throws Exception {
		System.out.println("Detail");
		System.out.println("booknum: " +booknum);
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBooknum(booknum);
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		request.setAttribute("one", bankBookDTO);
		return "/bankbook/detail"; //jsp의 주소
	}
	
	@RequestMapping (value = "add", method= RequestMethod.GET)
	public String addBook() {
		System.out.println("add get");
		return "/bankbook/add";
	}
	
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public String addBook(BankBookDTO bankBookDTO, HttpServletRequest request) throws Exception {
		System.out.println("add post");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result==1) {
			System.out.println("성공");
		}
		return "/bankbook/add";
	}
	
}
