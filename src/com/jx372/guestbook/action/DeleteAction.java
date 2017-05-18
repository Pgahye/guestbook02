package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.dao.guestBookDao;
import com.jx372.guestbook.vo.guestBookVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		String pwd = request.getParameter("pwd");

		guestBookVo vo=new guestBookVo();
		vo.setNo(Long.valueOf(no));
		vo.setPwd(pwd);

		
		new guestBookDao().delete(vo);
		
		//리다이렉트 응답
		
		response.sendRedirect("/guestbook2/gb");  //밑의 html은 필요가 없어짐 
	}

}
