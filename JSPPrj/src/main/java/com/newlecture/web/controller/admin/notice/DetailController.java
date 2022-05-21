package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 입력과 출력단만을 관리하는 Controller
		int id= Integer.parseInt(request.getParameter("id"));

		NoticeService service = new NoticeService();
		Notice notice = service.getNotice(id);
		request.setAttribute("n", notice);
		 
		 
		// redirect (페이지를 아예 이동하는 경우)
		// forward (페이지 내에서 자료를 처리)
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp")
				.forward(request, response);
	}
}
