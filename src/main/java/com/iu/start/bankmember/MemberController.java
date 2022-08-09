package com.iu.start.bankmember;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
//이 클래스는 controller 역할이고 container(객체 생명 주기 관리)가 이 클래스의 객체를 생성하도록 위임 
public class MemberController {
	//annotation 
	//@ : 설명+실행
		
	// /member/login
	//해당 URL이 요청왔을때 실행해야하는 메서드 생성
	
	@RequestMapping(value="/member/login")
	public void login() {
		System.out.println("로그인 실행");
	}
	
	//join   /member/join
	@RequestMapping(value="/member/join")
	public void join() {
		System.out.println("회원가입 실행");
	}

}
