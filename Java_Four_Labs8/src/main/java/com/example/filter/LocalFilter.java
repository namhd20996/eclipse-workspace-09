package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
public class LocalFilter implements Filter{
	private ServletContext servletContext;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String lang = req.getParameter("lang");
		if(lang!=null) {
			req.getSession().setAttribute("lang", lang);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
