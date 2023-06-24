package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Labs2_CTL
 */
@WebServlet("/labs2-ctl")
public class Labs2_CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Labs2_CTL() {
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
		if (action.equals("tinhDienTich")) {
			tinhDienTichTamGiac(request, response);
		} else if (action.equals("tinhChuVi")) {
			tinhChuViTamGiac(request, response);
		} else if (action.equals("register")) {
			dangKy(request, response);
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

	protected void tinhChuViTamGiac(HttpServletRequest request, HttpServletResponse response) {
		try {
			String canh_a = request.getParameter("canha");
			String canh_b = request.getParameter("canhb");
			String canh_c = request.getParameter("canhc");

			double a = Double.valueOf(canh_a);
			double b = Double.valueOf(canh_b);
			double c = Double.valueOf(canh_c);
			double dienTich;
			double chuVi;
			double p;

			request.setAttribute("canh_a", canh_a);
			request.setAttribute("canh_b", canh_b);
			request.setAttribute("canh_c", canh_c);

			String url = "/bai_1.jsp";
			String baoLoi = "";
			if ((a + b > c) && (a + c > b) && (b + c > a)) {
				chuVi = a + b + c;
				p = chuVi / 2;
				dienTich = Math.sqrt(p * ((p - a) * (p - b) * (p - c)));
				request.setAttribute("chuVi", chuVi);
//				request.setAttribute("dienTich", dienTich);
			} else {
				baoLoi = "Chưa thỏa mãn điều kiện để tạo thành 1 tam giác";
				request.setAttribute("baoLoi", baoLoi);
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void tinhDienTichTamGiac(HttpServletRequest request, HttpServletResponse response) {
		try {
			String canh_a = request.getParameter("canha");
			String canh_b = request.getParameter("canhb");
			String canh_c = request.getParameter("canhc");

			double a = Double.valueOf(canh_a);
			double b = Double.valueOf(canh_b);
			double c = Double.valueOf(canh_c);
			double dienTich;
			double chuVi;
			double p;

			request.setAttribute("canh_a", canh_a);
			request.setAttribute("canh_b", canh_b);
			request.setAttribute("canh_c", canh_c);

			String url = "/bai_1.jsp";
			String baoLoi = "";
			if ((a + b > c) && (a + c > b) && (b + c > a)) {
				chuVi = a + b + c;
				p = chuVi / 2;
				dienTich = Math.sqrt(p * ((p - a) * (p - b) * (p - c)));
//				request.setAttribute("chuVi", chuVi);
				request.setAttribute("dienTich", dienTich);
			} else {
				baoLoi = "Chưa thỏa mãn điều kiện để tạo thành 1 tam giác";
				request.setAttribute("baoLoi", baoLoi);
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String gioiTinh = request.getParameter("gender");
			String tinhTrangHonNhan =  request.getParameter("tinhTrangHonNhan");
			String quocTich =  request.getParameter("quocTich");
			String []soThichArr = request.getParameterValues("hobbies");
			
			String ghiChu =  request.getParameter("ghiChu");
			String url = "/success.jsp";
			String hobbies = "";
			for(String soThich: soThichArr) {
				hobbies += soThich;
				hobbies +=", ";
			}
				
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("matKhau", matKhau);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("tinhTrangHonNhan", tinhTrangHonNhan);
			request.setAttribute("quocTich", quocTich);
			request.setAttribute("soThich", hobbies);
			request.setAttribute("ghiChu", ghiChu);
			

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
