package com.assign.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assign.dto.VideoDTO;
import com.assign.service.IVideoService;
import com.assign.util.FormUtil;

@WebServlet(value = { "/admin/video" }, name = "ofVideoAdmin")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 8291140642125372041L;

	@Inject
	private IVideoService videoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		switch (action) {
		case "view":
			doGetOverView(req, resp);
			break;
		case "delete":
			doGetDelete(req, resp);
			break;
		case "add":
			doGetAdd(req, resp);
			break;
		case "edit":
			doGetEdit(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		switch (action) {
		case "add":
			doPostAdd(req, resp);
			break;
		case "edit":
			doPostEdit(req, resp);
			break;
		}
	}

	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		VideoDTO videoOrigin = videoService.findOneByHref(req.getParameter("hrefOrigin"));
		videoOrigin.setTitle(req.getParameter("title"));
		videoOrigin.setHref(req.getParameter("href"));
		videoOrigin.setDescription(req.getParameter("description"));
		videoOrigin.setPoster(req.getParameter("poster"));
		videoOrigin = videoService.update(videoOrigin);
		if (videoOrigin != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		VideoDTO video = videoService.create(FormUtil.toModel(VideoDTO.class, req));
		if (video != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	protected void doGetOverView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<VideoDTO> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		getServletContext().getRequestDispatcher("/WEB-INF/views/admin/video-overview.jsp").forward(req, resp);
	}

	protected void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String href = req.getParameter("href");
		VideoDTO video = videoService.delete(href);
		if (video != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	protected void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/admin/video-edit.jsp").forward(req, resp);
	}

	protected void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDTO video = videoService.findOneByHref(req.getParameter("href"));
		req.setAttribute("video", video);
		getServletContext().getRequestDispatcher("/WEB-INF/views/admin/video-edit.jsp").forward(req, resp);
	}
}
