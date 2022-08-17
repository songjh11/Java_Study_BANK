package com.iu.start.bankmember;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Autowired
	private BankMembersService bankMembersService;
	
//	@Autowired
//	public MemberController(BankMembersDAO bankMembersDAO) {
//		this.bankMembersDAO = bankMembersDAO;
//	}
	
	//annotation 
	//@ : 설명+실행
	
	@RequestMapping (value="logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		System.out.println("logout");
		session.invalidate();
		return "redirect:../";
	}
	
		
	// /member/login
	//해당 URL이 요청왔을때 실행해야하는 메서드 생성
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public void login() {
		System.out.println("로그인 실행");
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
//		model.addAttribute("member", bankMembersDTO);
//		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		
		if(bankMembersDTO!=null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
			return "redirect:./login.do";
		}
		return "redirect:../";
	}
	
	//join   /member/join <-GET
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 실행");
		System.out.println("GET");
		return "/member/join";
	}
	
	//POST
	@RequestMapping(value="join.do", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("회원가입 실행");
		System.out.println("POST");
		int result = bankMembersService.setJoin(bankMembersDTO);
			if(result==1) {
				System.out.println("성공");
				} else {
				System.out.println("실패");
					}
				return "redirect:./login.do";
	}
	
	//SEARCH 메서드명은 DAO의 메서드 명과 동일
	//member/search GET ID를 입력하는 폼
	//WEB-INF/views/member/search.jsp
	//ID를 입력해서 검색
	// /member/search POST /WEB-INF/views/member/list.jsp
	
	@RequestMapping(value="search.do", method= RequestMethod.GET)
	public void getSearchById() {
		System.out.println("Search");
//		return "/member/list";
		}
	
	@RequestMapping(value="search.do", method= RequestMethod.POST)
	public ModelAndView getSearchById(String search, Model model) throws Exception {
		System.out.println("post");
		List<BankMembersDTO> ar = bankMembersService.getSearchById(search);
		model.addAttribute("list", ar);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/list");
		return mv;
	}

}
