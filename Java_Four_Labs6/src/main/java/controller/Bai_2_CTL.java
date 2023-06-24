package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Favorites;
import entity.Report;
import entity.User;
import entity.Video;
import service.IReportService;
import service.IUserService;
import service.IVideoService;

@WebServlet(value = { "/bai-2-1", "/bai-2-2", "/bai-2-3", "/bai-2-4", "/bai-2-5" }, name = "OfBai2")
public class Bai_2_CTL extends HttpServlet {

	private static final long serialVersionUID = -3477601922249951055L;

	@Inject
	private IUserService userService;

	@Inject
	private IVideoService videoService;

	@Inject
	private IReportService reportService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/bai-2-1":
			doGetBai_2_1(req, resp);
			break;
		case "/bai-2-2":
			doGetBai_2_2(req, resp);
			break;
		case "/bai-2-3":
			doGetBai_2_3(req, resp);
			break;
		case "/bai-2-4":
			doGetBai_2_4(req, resp);
			break;
		case "/bai-2-5":
			doGetBai_2_5(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/bai-2-1":
			doPostBai_2_1(req, resp);
			break;
		case "/bai-2-2":
			doPostBai_2_2(req, resp);
			break;
		case "/bai-2-3":
			doPostBai_2_3(req, resp);
			break;
		case "/bai-2-4":
			doPostBai_2_4(req, resp);
			break;
		}
	}

	protected void doGetBai_2_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_1.jsp").forward(req, resp);
	}

	protected void doGetBai_2_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_2.jsp").forward(req, resp);
	}

	protected void doGetBai_2_3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_3.jsp").forward(req, resp);
	}

	protected void doGetBai_2_4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_4.jsp").forward(req, resp);
	}

	protected void doGetBai_2_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Report> list = reportService.findList();
		req.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_5.jsp").forward(req, resp);
	}

	protected void doPostBai_2_1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		User user = userService.findById(username);
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/bai-2-1");
		} else {
			List<Favorites> list = user.getFavorites();
			req.setAttribute("list", list);
			req.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_1.jsp").forward(req, resp);
		}
	}

	protected void doPostBai_2_2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		List<Video> list = videoService.findByKeyword(keyword);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-2-2");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_2.jsp").forward(req, resp);
		}
	}

	protected void doPostBai_2_3(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String videoId = req.getParameter("videoId");
		List<User> list = userService.findByVideoId(videoId);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-2-3");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_3.jsp").forward(req, resp);
		}
	}

	protected void doPostBai_2_4(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Boolean isFavorite = req.getParameter("options").equals("favorite");
		List<Video> list = videoService.findByFavorites(isFavorite);
		if (list.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/bai-2-4");
		} else {
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/WEB-INF/views/bai-2/bai_2_4.jsp").forward(req, resp);
		}
	}
}
