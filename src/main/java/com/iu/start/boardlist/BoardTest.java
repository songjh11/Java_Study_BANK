package com.iu.start.boardlist;

import java.util.ArrayList;

public class BoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoardDAO boardDAO = new BoardDAO();
		
		try {
			ArrayList<BoardDTO> ar = boardDAO.getList();
			for(BoardDTO b: ar) {
				System.out.println(b.getTextNum());
				System.out.println(b.gettName());
				System.out.println(b.getWriter()); 
				System.out.println(b.getwDate());
				System.out.println(b.getViewNum());
							}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
