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

import dao.UserDao;
import model.User;

@WebServlet("/labs5-ctl")
public class Labs5CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			String url = "/index.jsp";
			String notification = "";
			String action = request.getParameter("action");
			String edit = request.getParameter("edit");
			String delete = request.getParameter("delete");

			if (edit != null) {
				User u = new User();
				u.setId(edit);
				user = UserDao.getInstance().selectById(u);
			}

			if (delete != null) {
				User u = new User();
				u.setId(delete);
				UserDao.getInstance().delete(u);
			}

			if (action != null) {
				if (action.equals("create")) {
					if (UserDao.getInstance().insert(user)) {
						notification = "Insert success";
					} else {
						notification = "Insert fail";
					}
				} else if (action.equals("update")) {
					if (UserDao.getInstance().update(user)) {
						notification = "Update success";
					} else {
						notification = "Update fail";
					}
				} else if (action.equals("delete")) {
					if (UserDao.getInstance().delete(user)) {
						notification = "Delete success";
					} else {
						notification = "Delete fail";
					}
				} else if (action.equals("dang-nhap")) {
					login(request, response);
				} else if (action.equals("thay-doi-tt")) {
					HttpSession session = request.getSession();
					user = (User) session.getAttribute("userSession");
				}
			}

			request.setAttribute("user", user);
			request.setAttribute("notification", notification);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("tenDangNhap");
		String password = request.getParameter("matKhau");
		User u = new User();
		u.setId(id);
		u.setPassword(password);
		String message = "Đăng nhập thất bại!";
		if (UserDao.getInstance().selectFindOne(u) != null) {
			message = "Đăng nhập thành công!";
			HttpSession session = request.getSession();
			request.setAttribute("message", message);
			User ud = UserDao.getInstance().selectById(u);
			session.setAttribute("userSession", ud);
		}
	}

}
