package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import model.Staff;



/**
 * Servlet implementation class BeanCTL
 */
@WebServlet("/bean-ctl")
public class BeanCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text=html; charset=UTF-8");
//			String name = request.getParameter("name");
//			System.out.println(name);
			//Chuyển đổi time cho Bean
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);
			
			Staff bean = new Staff();
			BeanUtils.populate(bean,request.getParameterMap());
			
			
			try (PrintWriter out = response.getWriter()) {
//				out.println("<h1>Tên: " + name + "</h1>");
				out.println("<h1>Name: " + bean.getFullname() + "</h1>");
				out.println("<h1>Name: " + bean.getAge() + "</h1>");
				out.println("<h1>Name: " + bean.getSalary() + "</h1>");
				out.println("<h1>Name: " + bean.isGender() + "</h1>");
				out.println("<h1>Name: " + bean.getCountry() + "</h1>");
				out.println("<h1>Name: " + bean.getDob() + "</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
