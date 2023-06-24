package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import email.Email;
import model.LoginUser;
import model.Staff;
import util.CookieUtil;

/**
 * Servlet implementation class Labs3_CTL
 */
@MultipartConfig
@WebServlet("/labs3-ctl")
public class Labs3_CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Labs3_CTL() {
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
		if (action.equals("upload")) {
			upload(request, response);
		} else if (action.equals("register")) {
			registerBai_2(request, response);
		} else if (action.equals("send-email")) {
			sendEmail_Bai_5(request, response);
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

	protected void loginCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = CookieUtil.get("userName", request);
		String url = "/bai_4.jsp";
		HttpSession session = request.getSession();
		if (userName != null && !userName.equals("")) {
			request.setAttribute("message", "login success");
			session.setAttribute("userName", userName);
			url = "/dashboard.jsp";
			return;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void logOutCookie(HttpServletRequest request, HttpServletResponse response) {
		try {
			LoginUser bean = new LoginUser();
			HttpSession session = request.getSession();
			BeanUtils.populate(bean, request.getParameterMap());
			if (bean.getUser().equals("admin") && bean.getPassword().equals("admin")) {
				session.setAttribute("userName", bean.getUser());
				request.setAttribute("message", "login success");
				if (bean.isRemember()) {
					CookieUtil.add("userName", bean.getUser(), 2, response);
				} else {
					CookieUtil.add("userName", null, 0, response);
				}
			} else {
				request.setAttribute("message", "login fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	protected void registerBai_2(HttpServletRequest request, HttpServletResponse response) {
		try {
			String url = "/bai_2.jsp";

			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);

			Part part = request.getPart("hinhAnh");
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

			Staff bean = new Staff();
			BeanUtils.populate(bean, request.getParameterMap());

			bean.setHinhAnh(fileName);

			request.setAttribute("staff", bean);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/result.jsp";
		Part part_IMG = request.getPart("image");
		System.out.println(part_IMG);
		Part part_File = request.getPart("document");

		String uploadPath = getServletContext().getRealPath("/uploads");
		System.out.println(uploadPath);
		// Lấy thông tin người dùng upload
		String fileName_IMG = Path.of(part_IMG.getSubmittedFileName()).getFileName().toString();
		System.out.println(fileName_IMG);
		String fileName_File = Path.of(part_File.getSubmittedFileName()).getFileName().toString();
		// Nếu thư muc upload chưa tồn tại thì tạo mới một thư mục để lưu trữ
		if (!Files.exists(Path.of(uploadPath))) {
			Files.createDirectory(Path.of(uploadPath));
		}

		// Lưu xuống thư mục
		System.out.println(Paths.get(uploadPath.toString(), fileName_IMG).toString());
		part_IMG.write(Paths.get(uploadPath.toString(), fileName_IMG).toString());
		part_File.write(Paths.get(uploadPath.toString(), fileName_File).toString());

		request.setAttribute("image", fileName_IMG);
		request.setAttribute("document", fileName_File);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	@SuppressWarnings("unused")
	protected void sendEmail_Bai_5(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		String url = "/bai_5.jsp";
		if (Email.sendEmail(to, subject, body)) {
			request.setAttribute("notification", "Gửi email thành công");
		} else {
			request.setAttribute("notification", "Gửi email không thành công");
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
