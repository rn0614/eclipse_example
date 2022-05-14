package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// WebServlet은 해당 url요청이 오면 밑의 함수를 실행해라와 같은 의미
@WebServlet("/clac2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext application =req.getServletContext(); // application 사용
		HttpSession session= req.getSession();
		/*Cookie[] cookies= req.getCookies();
		
		for(Cookie c : cookies) {
			System.out.println("name:"+c.getName()+" value:"+c.getValue());
		}
		
		
		resp.setCharacterEncoding("UTF-8"); //인코딩할 때 UTF-8로
		resp.setContentType("text/html; charset=UTF-8");// 디코딩할 때 문서구조는 html이고 UTF-8로 하라
		PrintWriter out = resp.getWriter();
		
		String v_= req.getParameter("v");
		String op =req.getParameter("operator");
		
		int v=0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		if(op.equals("=")) {
			System.out.println("= 등장");
			//int x= (Integer)application.getAttribute("value");
			//int x= (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				System.out.println("name"+c.getName()+"value"+c.getValue());
				if(c.getName().equals("value"))
					System.out.println("name"+c.getName()+"value"+c.getValue());
					x= Integer.parseInt(c.getValue());
					break; //찾으면 나오기
			}
			System.out.println("x : " +x);
			int y=v;
			//String operator =(String)application.getAttribute("op");
			//String operator =(String)session.getAttribute("op");
			String operator="";
			for(Cookie c : cookies) {
				if(c.getName().equals("op"))
					System.out.println(c.getValue());
					operator= c.getValue();
					break; //찾으면 나오기
			}
			System.out.println("operator"+op);
			
			
			int result=0;
			
			if(operator.equals("+"))
				result=x+y;
			else
				result=x-y;
			
			out.printf("result is %d\n", result);
		}else {
			
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			
			Cookie ValueCookie = new Cookie("value", String.valueOf(v));
			Cookie OpCookie = new Cookie("op", op);
			resp.addCookie(ValueCookie);
			resp.addCookie(OpCookie);
			*/
			
			//다시 화면을 호출해준다.
			resp.sendRedirect("calc2.html");
		//}	
	}
}
