package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = { "/home-page", "/bai-3-4", "/bai-5", "/bai-6" }, name = "controllerOfHome")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/home-page":
			doGetHomePage(req, resp);
			break;
		case "/bai-3-4":
			doGetBai_3_4(req, resp);
			break;
		case "/bai-5":
			doGetBai_5(req, resp);
			break;
		case "/bai-6":
			doGetBai_6(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/bai-5":
			doPostBai_5(req, resp);
			break;
		case "/bai-6":
			doPostBai_6(req, resp);
			break;
		}
	}

	protected void doGetHomePage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	protected void doGetBai_3_4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "Chào thế giới Servlet/JSP!");
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-three-four/home.jsp").forward(req, resp);
	}

	protected void doGetBai_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-five/home.jsp").forward(req, resp);
	}

	protected void doGetBai_6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-six/home.jsp").forward(req, resp);
	}

	protected void doPostBai_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("name");
		req.setAttribute("fullName", fullName);
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-five/home.jsp").forward(req, resp);
	}

	protected void doPostBai_6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double length = Double.valueOf(req.getParameter("length"));
		double width = Double.valueOf(req.getParameter("width"));
		double acreage = length * width;
		double perimeter = (length + width) * 2;
		req.setAttribute("acreage", acreage);
		req.setAttribute("perimeter", perimeter);
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-six/home.jsp").forward(req, resp);
	}

}
