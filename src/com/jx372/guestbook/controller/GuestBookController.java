package com.jx372.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jx372.guestbook.action.GuestBookActionFactory;
import com.jx372.web.action.Action;
import com.jx372.web.action.ActionFactory;


@WebServlet("/gb")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8"); //한글처리 
		
		String actionName= request.getParameter("a");
		
		ActionFactory af = new GuestBookActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
