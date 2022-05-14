package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	/* get,post같이 처리시 service , get/post를 따로 받으려면 doget,dopost사용
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * if(req.getMethod().equals("GET")){ System.out.println("GET 요청이 왔습니다"); } else
	 * if(req.getMethod().equals("POST")){ System.out.println("POST 요청이 왔습니다"); }
	 * 
	 * super.service(req, resp); }
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		out.write("<form method=\"post\">");
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies =req.getCookies();
		
		String value =req.getParameter("value");
		String operator =req.getParameter("operator");
		String dot =req.getParameter("dot");
		
		String exp="";
		if(cookies!= null)
			for(Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		
		if(operator!= null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
			try {
				exp=String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(operator!= null && operator.equals("C")) {
			exp="";
			
			
		}else {
			exp += (value==null)?"":value;
			exp += (operator==null)?"":operator;
			exp += (dot==null)?"":dot;
		}
		
		Cookie expCookie =	new Cookie("exp", exp);
		if(operator!= null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("/calculator");
		resp.addCookie(expCookie);
		resp.sendRedirect("calculator");
	}
}
