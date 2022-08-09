package com.iu.start.bankmember;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankbook.BankBookDTO;

@Controller 
@RequestMapping (value="/member/")
//이 클래스는 controller 역할이고 container(객체 생명 주기 관리)가 이 클래스의 객체를 생성하도록 위임 
public class MemberController {
	//annotation 
	//@ : 설명+실행
		
	// /member/login
	//해당 URL이 요청왔을때 실행해야하는 메서드 생성
	
	@RequestMapping(value="login")
	public String login() {
		System.out.println("로그인 실행");
		return "/member/login";
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
		
		return "/member/join";
	}

}
