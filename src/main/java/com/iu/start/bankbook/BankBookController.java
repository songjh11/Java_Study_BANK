package com.iu.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/bankbook/*")
public class BankBookController {

	// /bankbook/list Get list
	// /bankbook/detail Get detail
	
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		System.out.println("List");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
//		setAttribute("list", ar);
//		return "/bankbook/list";
	}
	
	@RequestMapping (value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.addObject("one", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
//		return "/bankbook/detail"; //jsp의 주소
	}
	
	@RequestMapping (value = "add", method= RequestMethod.GET)
	public void addBook() {
		System.out.println("add GET");
//		return "/bankbook/add";
	}
	
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public ModelAndView addBook(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("add POST");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result==1) {
			System.out.println("계좌 추가 성공");
		}
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("redirect:./list");		
		return mv;
	}
	
}
