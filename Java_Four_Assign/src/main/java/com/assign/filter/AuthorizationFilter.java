package com.assign.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assign.constant.SystemConstant;
import com.assign.dto.UserDTO;
import com.assign.util.SessionUtil;

@SuppressWarnings("unused")
public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getServletPath();
		if (url.startsWith("/admin")) {
			UserDTO userDTO = (UserDTO) SessionUtil.getInstance().getValue(request, SystemConstant.USER_CURRENT);
			if (userDTO != null) {
				boolean isRole = userDTO.getRoleEntities().stream()
						.anyMatch(item -> item.getCode().equals(SystemConstant.ROLE_ADMIN));
				if(isRole) {
					filterChain.doFilter(request, response);
				}else {
					response.sendRedirect(request.getContextPath() + "/login?message=role invalid");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login?message=not login");
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
