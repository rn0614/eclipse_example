package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setCharacterEncoding("UTF-8"); //인코딩할 때 UTF-8로
		resp.setContentType("text/html; charset=UTF-8");// 디코딩할 때 문서구조는 html이고 UTF-8로 하라
		
		PrintWriter out = resp.getWriter();
		
		String temp =req.getParameter("cnt");
		int cnt=2 ;
		
		if(temp!=null && !temp.equals("")) {
			cnt= Integer.parseInt(temp);
		}
		
		
		for(int i=0 ; i<cnt; i++) {
			out.println((i+1)+": 안녕 Hello~asfd<br>");
		}
	}
}
