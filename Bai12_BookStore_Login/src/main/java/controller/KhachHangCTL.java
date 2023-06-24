package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KhachHangDao;
import lib.XDate;
import model.KhachHangModel;

/**
 * Servlet implementation class MyWebCTL
 */
@WebServlet("/dang-ky")
public class KhachHangCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangCTL() {
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
		response.setContentType("text=html; charset=UTF-8");

		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoTen = request.getParameter("hoVaTen");
		String gioiTinhStr = request.getParameter("gioiTinh");
		System.out.println(gioiTinhStr);
		boolean gioiTinh = gioiTinhStr.equalsIgnoreCase("Nam");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String soDienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");

		request.setAttribute("value_tenDangNhap", tenDangNhap);
//		request.setAttribute("value_matKhau", matKhau);
//		request.setAttribute("value_matKhauNhapLai", matKhauNhapLai);
		request.setAttribute("value_hoTen", hoTen);
		request.setAttribute("value_gioiTinh", gioiTinhStr);
		request.setAttribute("value_ngaySinh", ngaySinh);
		request.setAttribute("value_diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("value_diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("value_diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("value_soDienThoai", soDienThoai);
		request.setAttribute("value_email", email);
		request.setAttribute("value_dongYNhanMail", dongYNhanMail);

		String baoLoi = "";
		String url = "";
		if (KhachHangDao.getInstance().selectByUser(tenDangNhap) != null) {
			baoLoi += "Tên đăng nhập đã tồn tại. <br>";
		}

		if (!matKhau.equals(matKhauNhapLai)) {
			baoLoi += "Mật khẩu không khớp <br>";
		}

		request.setAttribute("baoLoi", baoLoi);

		if (baoLoi.length() > 0) {
			url = "/register.jsp";
		} else {
			Random rd = new Random();
			String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
			KhachHangModel kh = new KhachHangModel(maKhachHang, tenDangNhap, matKhau, hoTen, gioiTinh, diaChiKhachHang,
					diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail != null);
			KhachHangDao.getInstance().insert(kh);
			url = "/success.jsp";
		}

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
