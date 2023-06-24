package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@MultipartConfig
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text=html; charset=UTF-8");

			String name = request.getParameter("name");
			// Lấy ra value của img
			Part part = request.getPart("img");
			// Lấy ra đường dẫn của thư mục images
			String realPart = getServletContext().getRealPath("/images");
			// Lấy thông tin người dùng upload
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			// Nếu thư muc images chưa tồn tại thì tạo mới một thư mục để lưu trữ
			if (!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			// Lưu xuống thư mục
			part.write(realPart + "/" + fileName);
			try (PrintWriter out = response.getWriter()) {
				out.println("<h1>Name: " + name + "</h1>");
				out.println("<img src='images/" + fileName + "' width='80' height='80'>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
