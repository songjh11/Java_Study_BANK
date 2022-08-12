package com.iu.start.bankaccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankmember.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	
	private BankAccountDAO accountDAO;	
	
	public BankAccountController() {
		this.accountDAO = new BankAccountDAO();
	}
		
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		System.out.println("account GET");
		System.out.println(bankAccountDTO.getBooknum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member"); 
		bankAccountDTO.setUsername(bankMembersDTO.getUsername());
		//DTO-> username, booknum 필요
       int result = this.accountDAO.setAccount(bankAccountDTO);
       return "redirect:../bankbook/list.do";
		
	}

}
