package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDao;
import model.KhachHangModel;

/**
 * Servlet implementation class InformationCTL
 */
@WebServlet("/change-information")
public class InformationCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InformationCTL() {
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

		HttpSession session = request.getSession();
		KhachHangModel kh = (KhachHangModel) session.getAttribute("khachHang");
		String hoTen = request.getParameter("hoVaTen");
		String gioiTinhStr = request.getParameter("gioiTinh");
		boolean gioiTinh = gioiTinhStr.equals("Nam");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String soDienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		String baoLoi = "";
		String url = "/information.jsp";

		if (kh != null) {
			String maKhachHang = kh.getMaKhachHang();
			KhachHangModel khm = new KhachHangModel(maKhachHang, hoTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang,
					Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail != null);
			if (KhachHangDao.getInstance().updateInfo(khm) > 0) {
				baoLoi = "Thay đổi thông tin thành công";
				KhachHangModel khn = KhachHangDao.getInstance().selectById(khm);
				session.setAttribute("khachHang", khn);
			} else {
				baoLoi = "Thay đổi thông tin thất bại!";
			}
		}

		request.setAttribute("baoLoi", baoLoi);

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
