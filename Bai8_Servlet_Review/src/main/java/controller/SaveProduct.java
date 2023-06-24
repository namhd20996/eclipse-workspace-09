package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveProduct() {
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
		String maSanPham = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		String giaNhap = request.getParameter("giaNhap");
		String giaBan = request.getParameter("giaBan");
		String hanSuDung = request.getParameter("hanSuDung");
		String vat = request.getParameter("vat");
		String moTa = request.getParameter("moTa");

		String e_maSanPham = "";
		if (maSanPham == null || maSanPham.trim().length() < 0) {
			e_maSanPham += "Mã sản phẩm null";
		} else if (maSanPham.equals("123")) {
			e_maSanPham += "Mã 123 đã tồn tại";
		}

		request.setAttribute("e_maSanPham", e_maSanPham);

		// Forward value form
		request.setAttribute("value_maSanPham", maSanPham);
		request.setAttribute("value_tenSanPham", tenSanPham);
		request.setAttribute("value_giaNhap", giaNhap);
		request.setAttribute("value_giaBan", giaBan);
		request.setAttribute("value_hanSuDung", hanSuDung);
		request.setAttribute("value_vat", vat);
		request.setAttribute("value_moTa", moTa);

		String url = "/success.jsp";
		if (e_maSanPham.length() > 0) {
			url = "/product.jsp";
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
