package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDao;
import email.Email;
import model.KhachHangModel;
import util.Data;
import util.MaHoa;
import util.SoNgauNhien;

/**
 * Servlet implementation class KhachHangServlet
 */
@WebServlet("/khach-hang")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangServlet() {
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
		String action = request.getParameter("action");
		if (action.equals("dang-nhap")) {
			dangNhap(request, response);
		} else if (action.equals("dang-ky")) {
			dangKy(request, response);
		} else if (action.equals("dang-xuat")) {
			logOut(request, response);
		} else if (action.equals("doi-mat-khau")) {
			changePassword(request, response);
		} else if (action.equals("thay-doi-tt")) {
			changeInformation(request, response);
		}else if(action.equals("xac-thuc")) {
			xacThuc(request, response);
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

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
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
				url = "/khachhang/login.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text=html; charset=UTF-8");

			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoTen = request.getParameter("hoVaTen");
			String gioiTinhStr = request.getParameter("gioiTinh");
			boolean gioiTinh = gioiTinhStr.equalsIgnoreCase("Nam");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String soDienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");

			request.setAttribute("value_tenDangNhap", tenDangNhap);
//			request.setAttribute("value_matKhau", matKhau);
//			request.setAttribute("value_matKhauNhapLai", matKhauNhapLai);
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
			} else {
				matKhau = MaHoa.toSHA1(matKhau);
			}

			request.setAttribute("baoLoi", baoLoi);

			if (baoLoi.length() > 0) {
				url = "/khachhang/register.jsp";
			} else {
				Random rd = new Random();
				String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
				KhachHangModel kh = new KhachHangModel(maKhachHang, tenDangNhap, matKhau, hoTen, gioiTinh,
						diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email,
						dongYNhanMail != null);
				if(KhachHangDao.getInstance().insert(kh)>0) {
					// Lấy ra dãy số xác thực
					String soNgauNhien = SoNgauNhien.soNgauNhien();
					// Qui định time hiệu lực
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);
					// Set time hiệu lực 
					c.add(Calendar.DATE, 1);
					Date thoiGianHieuLucMaXacThuc = new Date(c.getTimeInMillis());
					// Trạng thái xác thực
					boolean trangThaiXacThuc = false;
					kh.setMaXacThuc(soNgauNhien);
					kh.setThoiGianHieuLucMaXacThuc(thoiGianHieuLucMaXacThuc);
					kh.setTrangThaiXacThuc(trangThaiXacThuc);
					if(KhachHangDao.getInstance().updateVerifyInformation(kh)>0) {
						// Gửi email
						Email.sendEmail(kh.getEmail(), "Gửi từ Duy Nam", getNoiDung(kh));
					}
				}
				url = "/khachhang/success.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text=html; charset=UTF-8");
			String matKhauHienTai = request.getParameter("matKhauHienTai");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

			HttpSession session = request.getSession();
			KhachHangModel kh = (KhachHangModel) session.getAttribute("khachHang");
			String baoLoi = "";
			String url = "/khachhang/changepassword.jsp";
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changeInformation(HttpServletRequest request, HttpServletResponse response) {
		try {
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
			String url = "/khachhang/information.jsp";

			System.out.println(diaChi);
			System.out.println(diaChiMuaHang);
			System.out.println(diaChiNhanHang);
			
			if (kh != null) {
				String maKhachHang = kh.getMaKhachHang();
				KhachHangModel khm = new KhachHangModel(maKhachHang, hoTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email, dongYNhanMail != null);
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String getNoiDung(KhachHangModel kh) {
		String link = "http://localhost:8080/BoostrapLearning/khach-hang?action=xac-thuc&maKhachHang="+kh.getMaKhachHang()+"&maXacThuc="+kh.getMaXacThuc();
		String noiDung = "<p>Xin ch&agrave;o bạn: <strong>"+kh.getHoTen()+"</strong></p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde;: <strong>"+kh.getMaXacThuc()+"</strong> x&aacute;c thực hoặc click trực tiếp v&agrave;o đường link&nbsp; sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; mail tự động xin vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Xin tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}
	
	private void xacThuc(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maKhachHang = request.getParameter("maKhachHang");
			String maXacThuc = request.getParameter("maXacThuc");
			String url = "/khachhang/notification.jsp";
			String msg = "";
			KhachHangModel kh = new KhachHangModel();
			kh.setMaKhachHang(maKhachHang);
			KhachHangModel khd = KhachHangDao.getInstance().selectById(kh);
			if(khd!=null) {
				// Kiểm tra mã xác thực có giống nhau không
				// Kiểm tra mã xác thực còn hiệu lực hay không
				if(khd.getMaXacThuc().equals(maXacThuc)) {
					// Thành công
					khd.setTrangThaiXacThuc(true);
					KhachHangDao.getInstance().updateVerifyInformation(khd);
					msg = "Xác thực thành công";
				}else {
					msg = "Xác thực không thành công";
				}
			}else {
				msg = "Tài khoản không tồn tại";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
