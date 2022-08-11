package com.iu.start.bankmember;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankbook.BankBookDTO;

@Controller 
@RequestMapping (value="/member/*")
//이 클래스는 controller 역할이고 container(객체 생명 주기 관리)가 이 클래스의 객체를 생성하도록 위임 
public class MemberController {
	//annotation 
	//@ : 설명+실행
		
	// /member/login
	//해당 URL이 요청왔을때 실행해야하는 메서드 생성
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login() {
		System.out.println("로그인 실행");
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO) throws Exception {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchById(bankMembersDTO.getUsername());
		if(ar.size()>0) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
			return "redirect:./login";
		}
		return "redirect:../";
	}
	
	//join   /member/join <-GET
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 실행");
		System.out.println("GET");
		return "/member/join";
	}
	
	//POST
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("회원가입 실행");
		System.out.println("POST");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		int result = bankMembersDAO.setJoin(bankMembersDTO);
			if(result==1) {
				System.out.println("성공");
				} else {
				System.out.println("실패");
					}
				return "redirect:./login";
	}
	
	//SEARCH 메서드명은 DAO의 메서드 명과 동일
	//member/search GET ID를 입력하는 폼
	//WEB-INF/views/member/search.jsp
	//ID를 입력해서 검색
	// /member/search POST /WEB-INF/views/member/list.jsp
	
	@RequestMapping(value="search", method= RequestMethod.GET)
	public void getSearchById() {
		System.out.println("Search");
//		return "/member/list";
		}
	
	@RequestMapping(value="search", method= RequestMethod.POST)
	public ModelAndView getSearchById(String search, Model model) throws Exception {
		System.out.println("post");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchById(search);
		model.addAttribute("list", ar);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/list");
		return mv;
	}

}
