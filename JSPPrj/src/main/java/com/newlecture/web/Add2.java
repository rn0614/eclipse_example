package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet�� �ش� url��û�� ���� ���� �Լ��� �����ض�� ���� �ǹ�
@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //���ڵ��� �� UTF-8��
		resp.setContentType("text/html; charset=UTF-8");// ���ڵ��� �� ���������� html�̰� UTF-8�� �϶�
		PrintWriter out = resp.getWriter();
		
		// ���� name ������ �� �͵��� �迭�� ����� �� ����.
		int result=0;
		String[] num_= req.getParameterValues("num");
		
		for(int i=0; i<num_.length; i++) {
			int num=Integer.parseInt(num_[i]);
			result+=num;
		}
		
		out.printf("result is %d\n", result);
	}
}
