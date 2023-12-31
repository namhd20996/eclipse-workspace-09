package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = { "/home-page", "/bai-1", "/bai-2", "/bai-3", "/bai-4" }, name = "controllerOf")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/home-page":
			doGetHomePage(req, resp);
			break;
		case "/bai-1":
			doGetBai_1(req, resp);
			break;
		case "/bai-2":
			doGetBai_2(req, resp);
			break;
		case "/bai-4":
			doGetBai_4(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/bai-1":
			doPostBai_1(req, resp);
			break;
		case "/bai-2":
			doPostBai_2(req, resp);
			break;
		}
	}

	protected void doGetHomePage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	protected void doGetBai_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-one/home.jsp").forward(req, resp);
	}
	
	protected void doGetBai_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-two/home.jsp").forward(req, resp);
	}

	protected void doGetBai_4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-four/home.jsp").forward(req, resp);
	}

	protected void doPostBai_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a = Double.valueOf(req.getParameter("canhA"));
		double b = Double.valueOf(req.getParameter("canhB"));
		double c = Double.valueOf(req.getParameter("canhC"));
		String action = req.getParameter("action");
		if ((a + b > c) && (a + c > b) && (b + c > a)) {
			double perimeter = a + b + c;
			double p = perimeter / 2;
			if (action.equals("tinhDienTich")) {
				req.setAttribute("acreage", Math.sqrt(p * ((p - a) * (p - b) * (p - c))));
			} else if (action.equals("tinhChuVi")) {
				req.setAttribute("perimeter", perimeter);
			}
		} else {
			req.setAttribute("error", "Không thỏa mãn các cạnh của một tam giác!");
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-one/home.jsp").forward(req, resp);
	}
	
	protected void doPostBai_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenDangNhap = req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau");
		String gioiTinh = req.getParameter("gender");
		String tinhTrangHonNhan =  req.getParameter("tinhTrangHonNhan");
		String quocTich =  req.getParameter("quocTich");
		String []soThichArr = req.getParameterValues("hobbies");
		String ghiChu =  req.getParameter("ghiChu");
		String hobbies = "";
		for(String soThich: soThichArr) {
			hobbies += soThich;
			hobbies +=", ";
		}
			
		req.setAttribute("tenDangNhap", tenDangNhap);
		req.setAttribute("matKhau", matKhau);
		req.setAttribute("gioiTinh", gioiTinh);
		req.setAttribute("tinhTrangHonNhan", tinhTrangHonNhan);
		req.setAttribute("quocTich", quocTich);
		req.setAttribute("soThich", hobbies);
		req.setAttribute("ghiChu", ghiChu);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-two/success.jsp").forward(req, resp);
	}
}
