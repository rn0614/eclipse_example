package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet은 해당 url요청이 오면 밑의 함수를 실행해라와 같은 의미
@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //인코딩할 때 UTF-8로
		resp.setContentType("text/html; charset=UTF-8");// 디코딩할 때 문서구조는 html이고 UTF-8로 하라
		PrintWriter out = resp.getWriter();
		
		// 같은 name 값으로 온 것들은 배열로 사용할 수 있음.
		int result=0;
		String[] num_= req.getParameterValues("num");
		
		for(int i=0; i<num_.length; i++) {
			int num=Integer.parseInt(num_[i]);
			result+=num;
		}
		
		out.printf("result is %d\n", result);
	}
}
