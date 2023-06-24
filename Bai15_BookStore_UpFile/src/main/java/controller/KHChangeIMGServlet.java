package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.KhachHangDao;
import model.KhachHangModel;

@MultipartConfig
@WebServlet("/khach-hang-thay-doi-anh")
public class KHChangeIMGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KHChangeIMGServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("1");
		HttpSession session = request.getSession();
		KhachHangModel khm = (KhachHangModel) session.getAttribute("khachHang");
		System.out.println(khm);
		if (khm != null) {
			try {
				String folder = getServletContext().getRealPath("hinhanh");
				System.out.println(folder);
				File file;
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;

				String contentType = request.getContentType();

				if (contentType.indexOf(contentType) >= 0) {
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// Quy dinh dung luong toi da cho 1 file
					factory.setSizeThreshold(maxMemSize);

					// Tao file upload
					ServletFileUpload upload = new ServletFileUpload(factory);

					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);

					for (FileItem fileItem : files) {
						if(!fileItem.isFormField()) {
							String fileName = System.currentTimeMillis() + fileItem.getName();
							String path = folder + "\\" + fileName;
							file = new File(path);
	
							fileItem.write(file);
	
							khm.setDuongDanAnh(fileName);
							
							KhachHangDao.getInstance().updateIMG(khm);
							khm = KhachHangDao.getInstance().selectById(khm);
						}else {
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name+" : "+value);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
