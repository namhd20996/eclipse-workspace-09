package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/mua-hang")
public class MuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String soLuong = request.getParameter("soLuong");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		

		// Kiểm tra số lượng
		double value_soLuong = 0;
		boolean checkError = false;
		try {
			value_soLuong = Double.valueOf(soLuong);
			if (value_soLuong <= 0) {
				checkError = true;
				request.setAttribute("e_soLuong", "Số lượng > 0!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			checkError = true;
			request.setAttribute("e_soLuong", "Nhập dữ liệu số không đúng!");
		}

		// Kiểm tra số điện thoại
		Pattern regex = Pattern.compile("\\d{10}");
		Matcher soDT = regex.matcher(soDienThoai);
		if(!soDT.matches()) {
			checkError = true;
			request.setAttribute("e_soDienThoai", "Vui lòng nhập 10 ký tự số");
		}
		
		// Kiểm tra email
		Pattern regexEmail = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$");
		Matcher emailM = regexEmail.matcher(email);
		if(!emailM.matches()) {
			checkError = true;
			request.setAttribute("e_email", "Sai định dạng email!");
		}
		
		String url = "/success.jsp";
		if(checkError) {
			url = "/index.jsp";
		}
		
		//Forward value form
		request.setAttribute("value_soLuong", soLuong);
		request.setAttribute("value_soDT", soDienThoai);
		request.setAttribute("value_email", email);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
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
