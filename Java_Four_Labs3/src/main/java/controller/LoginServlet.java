package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import model.LoginUser;
import util.CookieUtil;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginCookie(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginPostCookie(request, response);
	}

	protected void loginCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = CookieUtil.get("userName", request);
		String url = "/WEB-INF/views/lesson-four/home.jsp";
		HttpSession session = request.getSession();
		if (userName != null && !userName.equals("")) {
			request.setAttribute("message", "login success");
			session.setAttribute("userName", userName);
			url = "/WEB-INF/views/lesson-four/dashboard.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void loginPostCookie(HttpServletRequest request, HttpServletResponse response) {
		try {
			String url = "/WEB-INF/views/lesson-four/home.jsp";
			LoginUser bean = new LoginUser();
			HttpSession session = request.getSession();
			BeanUtils.populate(bean, request.getParameterMap());
			if (bean.getUser().equals("admin") && bean.getPassword().equals("admin")) {
				session.setAttribute("userName", bean.getUser());
				request.setAttribute("message", "login success");
				if (bean.isRemember()) {
					CookieUtil.add("userName", bean.getUser(), 2, response);
				} else {
					CookieUtil.add("userName", null, 0, response);
				}
			} else {
				request.setAttribute("message", "login fail");
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
