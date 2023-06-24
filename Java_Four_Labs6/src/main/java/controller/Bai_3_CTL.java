package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Video;
import service.IVideoService;
import util.DateUtil;

@WebServlet(value = { "/bai-3-1", "/bai-3-2", "/bai-3-3", "/bai-3-4" }, name = "OfBai3")
public class Bai_3_CTL extends HttpServlet {

	private static final long serialVersionUID = -4405195764410076649L;

	@Inject
	private IVideoService videoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/bai-3-1":
			doGetBai_3_1(req, resp);
			break;
		case "/bai-3-2":
			doGetBai_3_2(req, resp);
			break;
		case "/bai-3-3":
			doGetBai_3_3(req, resp);
			break;
		case "/bai-3-4":
			doGetBai_3_4(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/bai-3-1":
			doPostBai_3_1(req, resp);
			break;
		case "/bai-3-2":
			doPostBai_3_2(req, resp);
			break;
		case "/bai-3-3":
			doPostBai_3_3(req, resp);
			break;
		case "/bai-3-4":
			doPostBai_3_4(req, resp);
			break;
		}
	}

	protected void doGetBai_3_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_1.jsp").forward(req, resp);
	}

	protected void doGetBai_3_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_2.jsp").forward(req, resp);
	}

	protected void doGetBai_3_3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_3.jsp").forward(req, resp);
	}

	protected void doGetBai_3_4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_4.jsp").forward(req, resp);
	}

	protected void doPostBai_3_1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		List<Video> list = videoService.findByNamedQueryKeyword("Video.findByKeyword", map, true);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-3-1");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_1.jsp").forward(req, resp);
		}

	}

	protected void doPostBai_3_2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		List<Video> list = videoService.findByNamedQuery("Video.findByUser", username);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-3-2");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_1.jsp").forward(req, resp);
		}
	}

	protected void doPostBai_3_3(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String formDate = req.getParameter("formDate");
		String toDate = req.getParameter("toDate");
		Map<String, Object> map = new HashMap<>();
		map.put("min", DateUtil.getInstance().toDate(formDate, "yyyy-MM-dd"));
		map.put("max", DateUtil.getInstance().toDate(toDate, "yyyy-MM-dd"));
		List<Video> list = videoService.findByNamedQueryKeyword("Video.findInRange", map, false);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-3-3");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_3.jsp").forward(req, resp);
		}
	}

	protected void doPostBai_3_4(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] monthsStr = req.getParameterValues("months");
		List<Integer> arrInt = new ArrayList<>();
		for (String str : monthsStr) {
			arrInt.add(Integer.valueOf(str));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("months", arrInt);
		List<Video> list = videoService.findByNamedQueryKeyword("Video.findInMonths", map, false);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-3-4");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-3/bai_3_4.jsp").forward(req, resp);
		}
	}
}
