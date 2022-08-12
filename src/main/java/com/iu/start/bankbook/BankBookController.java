package com.iu.start.bankbook;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankaccount.BankAccountDAO;
import com.iu.start.bankaccount.BankAccountDTO;

@Controller
@RequestMapping (value = "/bankbook/*")
public class BankBookController {

	// /bankbook/list Get list
	// /bankbook/detail Get detail
	

	
	@RequestMapping (value = "list.do", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		System.out.println("List");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
//		setAttribute("list", ar);
//		return "/bankbook/list";
	}
	
	@RequestMapping (value = "detail.do", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		session.setAttribute("one", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
//		return "/bankbook/detail"; //jsp의 주소
	}
	
	@RequestMapping (value = "add.do", method= RequestMethod.GET)
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
		mv.setViewName("redirect:./list.do");		
		return mv;
	}
	//bankbook/update GET
	//WEB-INF/views/bankbook/update.jsp
	
	@RequestMapping (value="update.do", method= RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("update GET");
		BankBookDAO bankBookDAO =new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBooknum());
		model.addAttribute("update",bankBookDTO);	
	}
	
//	@RequestMapping (value="update", method= RequestMethod.GET)
//	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception {
//		System.out.println("update GET");
//		BankBookDAO bankBookDAO =new BankBookDAO();
//		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
//		System.out.println(bankBookDTO.getBooknum());
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("update", bankBookDTO);
//		return modelAndView;
//	}
	
	
	@RequestMapping (value="update.do", method=RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception  {
		System.out.println("update POST");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:./update.do");
		int result = bankBookDAO.setUpdate(bankBookDTO);
		if(result>0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./detail.do?booknum="+bankBookDTO.getBooknum());
		}
		return modelAndView;
	}
	
	//bankbook/delete GET
	@RequestMapping (value="delete.do", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("delete");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ModelAndView modelAndView = new ModelAndView(); 
		int result = bankBookDAO.delete(bankBookDTO);
		System.out.println(result);
		if(result>0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./list.do");
					}
		return modelAndView;
		
	}
	
}
