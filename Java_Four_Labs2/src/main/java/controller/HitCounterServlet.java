package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HitCounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Integer count;

	private Path path = Paths.get("D:/temp/count.txt");

	@Override
	public void init() throws ServletException {
		try {
			count = Integer.parseInt(Files.readAllLines(path).get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		count++;
		req.setAttribute("count", count);
	}

	@Override
	public void destroy() {
		try {
			Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
