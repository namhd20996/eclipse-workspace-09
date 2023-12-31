package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;

@WebServlet("/user-servler")
public class UserServler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		String action = request.getParameter("action");
		String url = "/bai_2/login.jsp";

		List<UserModel> users = Arrays.asList(new UserModel("User1", "123", true), new UserModel("User1", "123", true),
				new UserModel("User1", "123", true));
		request.setAttribute("message", "Quản lý người sử dụng!");
		request.setAttribute("form", users.get(0));
		request.setAttribute("items", users);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
