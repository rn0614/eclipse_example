package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet은 해당 url요청이 오면 밑의 함수를 실행해라와 같은 의미
@WebServlet("/clac")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //인코딩할 때 UTF-8로
		resp.setContentType("text/html; charset=UTF-8");// 디코딩할 때 문서구조는 html이고 UTF-8로 하라
		PrintWriter out = resp.getWriter();
		
		int x=0;
		int y=0;
		
		String x_= req.getParameter("x");
		String y_= req.getParameter("y");
		String op= req.getParameter("operator");
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);		
		
		int result = (op.equals("덧셈")) ? x+y: x-y;
		
		out.printf("result is %d\n", result);
	}
}
