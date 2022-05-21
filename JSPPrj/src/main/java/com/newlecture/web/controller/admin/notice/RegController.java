package com.newlecture.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;
// 저장위치, 저장 사이즈 , 한개당 용량제한, 전체 용량제한
/*@MultipartConfig(
	location="/tmp",
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*50*5
)*/


@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달되는 요청값이 없을 때 기본값의 설정 유무를 한번 생각해봐야함
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String isOpen= request.getParameter("open");
		
		
		/*
		 * Part filePart = request.getPart("file"); filePart.getInputStream();
		 * 
		 * // 물리적 경로 추출 String realPath=request.getServletContext().getRealPath(isOpen);
		 * System.out.println(realPath);
		 */
		
		boolean pub = false;
		if(isOpen != null)
			pub =true;
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
		
	}
}
