package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.dao.guestBookDao;
import com.jx372.guestbook.vo.guestBookVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String name = WebUtils.checkParameter(request.getParameter("name"), "");
		String pwd =  WebUtils.checkParameter(request.getParameter("pwd"), "");
		String message = WebUtils.checkParameter(request.getParameter("message"), "");
		
		guestBookVo vo=new guestBookVo();
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setMessage(message);
		
		new guestBookDao().insert(vo);
		
		//리다이렉트 응답
		WebUtils.redirect(request.getContextPath()+"/gb", request, response);
		//response.sendRedirect("/guestbook2/gb");  //밑의 html은 필요가 없어짐 

	}

}
