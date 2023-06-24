package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = { "/home/index", "/home/about", "/home/contact", "/home/bai-2", "/home/bai-3", "/home/new",
		"/home/contact/bai-3","/home/bai-4" }, name = "ofHome")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4906367278052805245L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		String url = "/layout.jsp";
		switch (action) {
		case "/home/index":
			req.setAttribute("view", "/WEB-INF/views/home/index.jsp");
			break;
		case "/home/about":
			req.setAttribute("view", "/WEB-INF/views/home/about.jsp");
			break;
		case "/home/contact":
			req.setAttribute("view", "/WEB-INF/views/home/contact.jsp");
			break;
		case "/home/bai-2":
			url = "/WEB-INF/views/bai-2/bai_2.jsp";
			break;
		case "/home/bai-3":
			url = "/WEB-INF/views/bai-3/bai_3.jsp";
			break;
		case "/home/bai-4":
			url = "/WEB-INF/views/bai-4/bai_4.jsp";
			break;
		case "/home/new":
			url = "/WEB-INF/views/bai-3/new.jsp";
			break;
		case "/home/contact/bai-3":
			url = "/WEB-INF/views/bai-3/contact.jsp";
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
