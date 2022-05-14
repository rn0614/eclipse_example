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

// WebServlet은 해당 url요청이 오면 밑의 함수를 실행해라와 같은 의미
@WebServlet("/calcpage")
public class Calcpage extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp) 
			throws ServletException, IOException {

		
		Cookie[] cookies =req.getCookies();
		String exp ="0";
		if(cookies!= null)
			for(Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		
		
		resp.setCharacterEncoding("UTF-8"); //인코딩할 때 UTF-8로
		resp.setContentType("text/html; charset=UTF-8");// 디코딩할 때 문서구조는 html이고 UTF-8로 하라
		PrintWriter out = resp.getWriter();
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height: 50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size: 24px;");
		out.write("font-weight: bold;");
		out.write("text-align: right;");
		out.write("padding: 0px 0px;");
	
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"clac3\" method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>",exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"CE\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"C\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"BS\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"/\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"7\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"8\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"9\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"*\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"4\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"5\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"6\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"-\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"1\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"2\"/></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"3\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"+\"/></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input name=\"value\" type=\"submit\" value=\"0\"/></td>");
		out.write("<td><input name=\"dot\" type=\"submit\" value=\".\"/></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"=\"/></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
		
	}
}
				
