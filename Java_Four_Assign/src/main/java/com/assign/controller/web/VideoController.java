package com.assign.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assign.constant.SystemConstant;
import com.assign.dto.HistoryDTO;
import com.assign.dto.UserDTO;
import com.assign.dto.VideoDTO;
import com.assign.service.IHistorySevice;
import com.assign.service.IVideoService;
import com.assign.util.SessionUtil;

@WebServlet(value = { "/video" }, name = "OfVideo")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = -9072400234716639707L;

	@Inject
	private IVideoService videoService;
	
	@Inject
	private IHistorySevice historySevice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String href = req.getParameter("id");
		switch (action) {
		case "watch":
			doGetWatch(req, resp, href);
			break;
		case "like":
			doGetLike(req, resp, href);
			break;
		}
	}

	private void doGetLike(HttpServletRequest req, HttpServletResponse resp, String href)throws ServletException, IOException {
		resp.setContentType("application/json");
		UserDTO userCurrent = (UserDTO) SessionUtil.getInstance().getValue(req, SystemConstant.USER_CURRENT);
		Boolean result = historySevice.updateLikeOrUnLike(userCurrent, href);
		if(result == Boolean.TRUE) {
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}

	private void doGetWatch(HttpServletRequest req, HttpServletResponse resp, String href)
			throws ServletException, IOException {
		VideoDTO videoDTO = videoService.findOneByHref(href);
		req.setAttribute("video", videoDTO);
		UserDTO userCurrent = (UserDTO) SessionUtil.getInstance().getValue(req, SystemConstant.USER_CURRENT);
		if(userCurrent!=null) {
			HistoryDTO historyDTO = historySevice.create(userCurrent, videoDTO);
			req.setAttribute("flagLikeBtn", historyDTO.getIsLike());
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/web/video-detail.jsp").forward(req, resp);
	}

}
