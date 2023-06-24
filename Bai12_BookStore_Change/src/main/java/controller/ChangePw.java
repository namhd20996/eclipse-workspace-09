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
 * Servlet implementation class ChangePw
 */
@WebServlet("/doi-mat-khau")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePw() {
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
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

		HttpSession session = request.getSession();
		KhachHangModel kh = (KhachHangModel) session.getAttribute("khachHang");
		String baoLoi = "";
		String url = "/changepassword.jsp";
		String matKhauSHA_1 = MaHoa.toSHA1(matKhauHienTai);
		if (kh == null) {
			baoLoi = "Bạn chưa đăng nhập vào hệ thống!";

		} else {
			if (!matKhauSHA_1.equals(kh.getMatKhau())) {
				baoLoi = "Mật khẩu cũ không chính xác";
			} else {
				if (matKhauMoi.equals(matKhauHienTai)) {
					baoLoi = "Mật khẩu hiện tại trùng với mật khẩu mới!";
				} else if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
					baoLoi = "Mật khẩu không khớp!";
				} else {
					String matKhauMoiSHA_1 = MaHoa.toSHA1(matKhauMoi);
					kh.setMatKhau(matKhauMoiSHA_1);
					if (KhachHangDao.getInstance().changePassword(kh) > 0) {
						baoLoi = "Thay đổi mật khẩu thành công!";
					} else {
						baoLoi = "Thay đổi mật khẩu không thành công!";
					}
				}
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
