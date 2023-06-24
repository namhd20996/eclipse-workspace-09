package com.assign.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assign.dto.UserDTO;
import com.assign.dto.VideoLikedInfo;
import com.assign.service.IStatsService;
import com.assign.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(value = { "/admin", "/admin/favorites" }, name = "ofAdmin")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -7532322523456174695L;

	@Inject
	private IStatsService statsService;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/admin":
			doGetHome(req, resp);
			break;
		case "/admin/favorites":
			doGetFavorites(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	private void doGetFavorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		String videoHref = req.getParameter("href");
		List<UserDTO> users = userService.findUsersLikedVideoByVideoHref(videoHref);
		if (users.isEmpty()) {
			resp.setStatus(400);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResp = mapper.writeValueAsString(users);
			resp.setStatus(200);
			out.print(dataResp);
			out.flush();
		}
//		getServletContext().getRequestDispatcher("/WEB-INF/views/admin/home.jsp").forward(req, resp);
	}

	protected void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoLikedInfo> videos = statsService.findVideoLikedInfo();
		req.setAttribute("videos", videos);
		getServletContext().getRequestDispatcher("/WEB-INF/views/admin/home.jsp").forward(req, resp);
	}
}
