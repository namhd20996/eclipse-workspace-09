package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list-servlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<Item> list = Arrays.asList(new Item("Nokia 2020", "mountains-and-hills-5112952__480.jpg", 500, 0.1),
				new Item("Samsung Xyz", "mountains-and-hills-5112952__480.jpg", 700, 0.15),
				new Item("iPhone Xy", "mountains-and-hills-5112952__480.jpg", 900, 0.25),
				new Item("Sony Erricson", "mountains-and-hills-5112952__480.jpg", 55, 0.3),
				new Item("Seamen", "mountains-and-hills-5112952__480.jpg", 70, 0.5),
				new Item("Oppo 2021", "mountains-and-hills-5112952__480.jpg", 200, 0.2),
				new Item("Samsung Xyz", "mountains-and-hills-5112952__480.jpg", 700, 0.15),
				new Item("iPhone Xy", "mountains-and-hills-5112952__480.jpg", 900, 0.25),
				new Item("Sony Erricson", "mountains-and-hills-5112952__480.jpg", 55, 0.3),
				new Item("Seamen", "mountains-and-hills-5112952__480.jpg", 70, 0.5),
				new Item("Oppo 2021", "mountains-and-hills-5112952__480.jpg", 200, 0.2));
		String url = "/bai_4/list.jsp";
		
		request.setAttribute("items", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		String url = "/bai_3/detail.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
