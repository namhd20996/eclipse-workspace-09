package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDao;
import model.KhachHangModel;
import util.MaHoa;

/**
 * Servlet implementation class LoginCTL
 */
@WebServlet("/dang-nhap")
public class LoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCTL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text=html; charset=UTF-8");

		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");

		KhachHangModel kh = new KhachHangModel();
		kh.setTenDangNhap(tenDangNhap);
		kh.setMatKhau(MaHoa.toSHA1(matKhau));
		KhachHangModel khm = KhachHangDao.getInstance().checkLogin(kh);
		String url = "/index.jsp";
		if (khm != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khm);
		} else {
			request.setAttribute("baoLoi", "Tên đăng nhập or mật khẩu không đúng!");
			url = "/login.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
