package com.iu.start.boardlist;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value="/board/*")
public class BoardController {
	BoardDAO boardDAO = new BoardDAO();
	
	@RequestMapping(value="list.do", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("List");
		ArrayList<BoardDTO> ar = boardDAO.getList();
		model.addAttribute("blist", ar);
	}
	
	@RequestMapping(value="detail.do", method=RequestMethod.GET)
	public void getDetail(BoardDTO boardDTO, HttpSession session) throws Exception {
		System.out.println("Detail");
		boardDTO = boardDAO.getDetail(boardDTO);
		session.setAttribute("bdetail", boardDTO);
			}
	
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public void setAdd() throws Exception {
		System.out.println("Add");
			}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public ModelAndView insertAdd(BoardDTO boardDTO) throws Exception {
		System.out.println("insertAdd");
		int result = boardDAO.setBoard(boardDTO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board/add.do");
		if(result>0) {
			modelAndView.setViewName("redirect:./list.do");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public void setUpdate(BoardDTO boardDTO) throws Exception {
		System.out.println("Update");
		boardDTO = boardDAO.getDetail(boardDTO);
		System.out.println(boardDTO.getTextNum());
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public ModelAndView postUpdate(BoardDTO boardDTO) throws Exception {
		System.out.println("postUpdate");
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("/board/update.do");
		int result = boardDAO.update(boardDTO);
		System.out.println(result);
		if (result>0) {
			modelAndView.setViewName("redirect:./list.do");
		}
		return modelAndView;		
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.GET)
	public void getDelete() throws Exception {
		System.out.println("Delete");
	}
}
