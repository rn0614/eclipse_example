package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;


@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{
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
		
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}
}
