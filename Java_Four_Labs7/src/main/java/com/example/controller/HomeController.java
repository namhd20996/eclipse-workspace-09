package com.example.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.UserEntity;
import com.example.service.IUserService;
import com.example.util.FormUtil;
import com.example.util.SessionUtil;

@WebServlet(value = { "/index", "/login", "/logout" }, name = "home")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4906367278052805245L;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/logout":
			doGetLogout(req, resp);
			break;
		}
	}

	private void doGetLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionUtil.getInstance().removeValue(req, "user");
		resp.sendRedirect(req.getContextPath() + "/index");
	}

	protected void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/login":
			doPostLogin(req, resp);
			break;
		}
	}

	protected void doPostLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserEntity user = FormUtil.toModel(UserEntity.class, req);
		user = userService.findOneByUsernameAndPassword(user);
		if (user != null) {
			SessionUtil.getInstance().putValue(req, "user", user);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login?message");
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
