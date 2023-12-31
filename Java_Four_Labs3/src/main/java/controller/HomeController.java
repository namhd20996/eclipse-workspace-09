package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import email.Email;
import model.Staff;

@MultipartConfig
@WebServlet(value = { "/home-page", "/bai-1", "/bai-2", "/bai-5", "/bai-4" }, name = "controllerOf")
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
		case "/bai-5":
			doGetBai_5(req, resp);
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
		case "/bai-5":
			doPostBai_5(req, resp);
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

	protected void doGetBai_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-five/home.jsp").forward(req, resp);
	}

	protected void doPostBai_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part_IMG = req.getPart("image");
		System.out.println(part_IMG);
		Part part_File = req.getPart("document");

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

		req.setAttribute("image", fileName_IMG);
		req.setAttribute("document", fileName_File);
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-one/result.jsp").forward(req, resp);
	}

	protected void doPostBai_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);

			Part part = req.getPart("hinhAnh");
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
			BeanUtils.populate(bean, req.getParameterMap());

			bean.setHinhAnh(fileName);

			req.setAttribute("staff", bean);
			getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-two/home.jsp").forward(req, resp);
		} catch (Exception e) {
		}
	}

	protected void doPostBai_5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String subject = req.getParameter("subject");
		String body = req.getParameter("body");
		if (Email.sendEmail(to, subject, body)) {
			req.setAttribute("notification", "Gửi email thành công");
		} else {
			req.setAttribute("notification", "Gửi email không thành công");
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/lesson-five/home.jsp").forward(req, resp);
	}

}
