package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;


@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd= request.getParameter("cmd");
		//
		
		switch(cmd) {
		case "ÀÏ°ý°ø°³":
			for(String openId : openIds) {
				System.out.printf("open Id :%s \n",openId);
			}
			break;
			
		case "ÀÏ°ý»èÁ¦":
			NoticeService service = new NoticeService();
			int[] ids = new int[delIds.length];
			for(int i=0; i<delIds.length;i++) {
				ids[i] = Integer.parseInt(delIds[i]);
			}
			int result =service.deleteNoticeAll(ids);
			break;
		}
		
		response.sendRedirect("list");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list?f=title&q=a
		
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ =request.getParameter("p");
		
		int page=1;
		String field = "title";
		String query = "";
		if( page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		if(field_ != null && !field_.equals(""))
			field=field_;
		
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		
		NoticeService service = new NoticeService();
		List<NoticeView> notices = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);
		
		
		request.setAttribute("notices", notices);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
	}
}
