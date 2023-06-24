package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReportDTO;
import dto.VideoDTO;
import service.IReportService;
import service.IVideoService;

@WebServlet(value = { "/bai-4-1", "/bai-4-2" }, name = "OfBai4")
public class Bai_4_CTL extends HttpServlet {

	private static final long serialVersionUID = -4405195764410076649L;

	@Inject
	private IVideoService videoService;

	@Inject
	private IReportService reportService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String action = req.getServletPath();
		switch (action) {
		case "/bai-4-1":
			doGetBai_4_1(req, resp);
			break;
		case "/bai-4-2":
			doGetBai_4_2(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGetBai_4_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoDTO> list = videoService.findByNativeNameQuery("Report.random10");
		req.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-4/bai_4_1.jsp").forward(req, resp);
	}

	protected void doGetBai_4_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("year") != null) {
			Integer year = Integer.valueOf(req.getParameter("year"));
			List<ReportDTO> list = reportService.findStore(year);
			System.out.println("123");
			req.setAttribute("list", list);
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/bai-4/bai_4_2.jsp").forward(req, resp);
	}

}
