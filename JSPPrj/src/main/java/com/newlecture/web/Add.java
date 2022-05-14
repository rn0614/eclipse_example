package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet�� �ش� url��û�� ���� ���� �Լ��� �����ض�� ���� �ǹ�
@WebServlet("/add")
public class Add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //���ڵ��� �� UTF-8��
		resp.setContentType("text/html; charset=UTF-8");// ���ڵ��� �� ���������� html�̰� UTF-8�� �϶�
		PrintWriter out = resp.getWriter();
		
		int x=0;
		int y=0;
		
		String x_= req.getParameter("x");
		String y_= req.getParameter("y");
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);		
		
		out.printf("result is %d\n", x+y);
	}
}
