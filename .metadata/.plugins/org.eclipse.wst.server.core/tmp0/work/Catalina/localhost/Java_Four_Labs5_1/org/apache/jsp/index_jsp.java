/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.79
 * Generated at: 2023-01-08 05:02:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import dao.UserDao;
import java.util.List;
import model.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("dao.UserDao");
    _jspx_imports_classes.add("org.apache.jasper.tagplugins.jstl.core.ForEach");
    _jspx_imports_classes.add("model.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("	integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String notification = request.getAttribute("notification") + "";
	User user = (User) request.getAttribute("user");
	String id = "";
	String password = "";
	String fullname = "";
	String email = "";
	boolean admin;
	String adminStr = "";
	if (user != null) {
		id = user.getId() + "";
		fullname = user.getFullname() + "";
		email = user.getEmail() + "";
		admin = user.getAdmin();
	}
	id = id.equals("null") ? "" : id;
	fullname = fullname.equals("null") ? "" : fullname;
	email = email.equals("null") ? "" : email;
	List<User> list = UserDao.getInstance().selectAll();
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<!-- Navbar -->\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg bg-light\">\r\n");
      out.write("		<div class=\"container-fluid\">\r\n");
      out.write("			<a class=\"navbar-brand\" href=\"#\">Navbar</a>\r\n");
      out.write("			<button class=\"navbar-toggler\" type=\"button\"\r\n");
      out.write("				data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\"\r\n");
      out.write("				aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n");
      out.write("				aria-label=\"Toggle navigation\">\r\n");
      out.write("				<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("			</button>\r\n");
      out.write("			<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("				<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("					<li class=\"nav-item\"><a class=\"nav-link active\"\r\n");
      out.write("						aria-current=\"page\" href=\"#\">Home</a></li>\r\n");
      out.write("					<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Link</a></li>\r\n");
      out.write("					<li class=\"nav-item dropdown\"><a\r\n");
      out.write("						class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\"\r\n");
      out.write("						data-bs-toggle=\"dropdown\" aria-expanded=\"false\"> Dropdown </a>\r\n");
      out.write("						<ul class=\"dropdown-menu\">\r\n");
      out.write("							<li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\r\n");
      out.write("							<li><a class=\"dropdown-item\" href=\"#\">Another action</a></li>\r\n");
      out.write("							<li><hr class=\"dropdown-divider\"></li>\r\n");
      out.write("							<li><a class=\"dropdown-item\" href=\"#\">Something else\r\n");
      out.write("									here</a></li>\r\n");
      out.write("						</ul></li>\r\n");
      out.write("					<li class=\"nav-item\"><a class=\"nav-link disabled\">Disabled</a>\r\n");
      out.write("					</li>\r\n");
      out.write("				</ul>\r\n");
      out.write("				<form class=\"d-flex\" role=\"search\">\r\n");
      out.write("					<input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\"\r\n");
      out.write("						aria-label=\"Search\">\r\n");
      out.write("					<button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\r\n");
      out.write("\r\n");
      out.write("					");

					User ud = (User) session.getAttribute("userSession");
					
					if (ud == null) {
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("					<a class=\"btn btn-primary\" style=\"white-space: nowrap;\"\r\n");
      out.write("						href=\"");
      out.print(url );
      out.write("/login.jsp\"> Đăng nhập </a>\r\n");
      out.write("					");

					} else {
					
      out.write("\r\n");
      out.write("					\r\n");
      out.write("					<ul class=\"navbar-nav me-auto mb-2 mb-lg-0 bg-infor \">\r\n");
      out.write("						<li class=\"nav-item dropdown dropstart\"><a\r\n");
      out.write("							class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\"\r\n");
      out.write("							data-bs-toggle=\"dropdown\" aria-expanded=\"false\"> Tài khoản</a>\r\n");
      out.write("							<ul class=\"dropdown-menu\">\r\n");
      out.write("								<li><a class=\"dropdown-item\" href=\"#\">Đơn hàng của tôi</a></li>\r\n");
      out.write("								<li><a class=\"dropdown-item\" href=\"#\">Thông báo</a></li>\r\n");
      out.write("								<li><a class=\"dropdown-item\"\r\n");
      out.write("									href=\"");
      out.print(url );
      out.write("/labs5-ctl?action=thay-doi-tt\">Thay đổi thông tin</a></li>\r\n");
      out.write("									<li><a class=\"dropdown-item\"\r\n");
      out.write("									href=\"");
      out.print(url );
      out.write("/khachhang/changeimg.jsp\">Thay đổi ảnh</a></li>\r\n");
      out.write("								<li><a class=\"dropdown-item\"\r\n");
      out.write("									href=\"");
      out.print(url );
      out.write("/khachhang/changepassword.jsp\">Đổi mật khẩu</a></li>\r\n");
      out.write("								<li><hr class=\"dropdown-divider\"></li>\r\n");
      out.write("								<li><a class=\"dropdown-item\"\r\n");
      out.write("									href=\"");
      out.print(url );
      out.write("/khach-hang?action=dang-xuat\">Thoát tài khoản</a></li>\r\n");
      out.write("							</ul></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					");

					}
					String message = request.getAttribute("message")+"";
					
      out.write("\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("	<!-- Navbar end -->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	<h1>");
      out.print( message);
      out.write("</h1>\r\n");
      out.write("		<h1 style=\"text-align: center;\">Quản Lý Thông Tin Người Dùng</h1>\r\n");
      out.write("		<form action=\"labs5-ctl\" method=\"post\">\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("\r\n");
      out.write("				<label for=\"exampleInputEmail1\" class=\"form-label\">Username\r\n");
      out.write("				</label> <input name=\"id\" type=\"text\" class=\"form-control\"\r\n");
      out.write("					id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\"\r\n");
      out.write("					value=\"");
      out.print(id);
      out.write("\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"exampleInputPassword1\" class=\"form-label\">Password</label>\r\n");
      out.write("				<input name=\"password\" type=\"password\" class=\"form-control\"\r\n");
      out.write("					id=\"exampleInputPassword1\">\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"exampleInputEmail1\" class=\"form-label\">Fullname</label>\r\n");
      out.write("				<input name=\"fullname\" type=\"text\" class=\"form-control\"\r\n");
      out.write("					id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\"\r\n");
      out.write("					value=\"");
      out.print(fullname);
      out.write("\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"exampleInputPassword1\" class=\"form-label\">Email</label>\r\n");
      out.write("				<input name=\"email\" type=\"email\" class=\"form-control\"\r\n");
      out.write("					id=\"exampleInputPassword1\" value=\"");
      out.print(email);
      out.write("\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"exampleInputEmail1\" class=\"form-label\">Role</label> <br>\r\n");
      out.write("				<div class=\"form-check form-check-inline\">\r\n");
      out.write("					<input class=\"form-check-input\" type=\"radio\" name=\"admin\"\r\n");
      out.write("						id=\"inlineRadio1\" value=\"true\"> <label\r\n");
      out.write("						class=\"form-check-label\" for=\"inlineRadio1\">Admin</label>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-check form-check-inline\">\r\n");
      out.write("					<input class=\"form-check-input\" type=\"radio\" name=\"admin\"\r\n");
      out.write("						id=\"inlineRadio2\" value=\"false\"> <label\r\n");
      out.write("						class=\"form-check-label\" for=\"inlineRadio2\">User</label>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			");

			if (!notification.equals("null")) {
			
      out.write("\r\n");
      out.write("			<label for=\"exampleInputEmail1\" class=\"form-label\"\r\n");
      out.write("				style=\"color: red;\">");
      out.print(notification);
      out.write("</label>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("			<hr>\r\n");
      out.write("\r\n");
      out.write("			<button type=\"submit\" name=\"action\" value=\"create\"\r\n");
      out.write("				class=\"btn btn-primary\">Create</button>\r\n");
      out.write("			<button type=\"submit\" name=\"action\" value=\"update\"\r\n");
      out.write("				class=\"btn btn-warning\">Update</button>\r\n");
      out.write("			<button type=\"submit\" name=\"action\" value=\"delete\"\r\n");
      out.write("				class=\"btn btn-danger\">Delete</button>\r\n");
      out.write("			<button type=\"reset\" name=\"action\" value=\"reset\"\r\n");
      out.write("				class=\"btn btn-success\">Reset</button>\r\n");
      out.write("		</form>\r\n");
      out.write("		<table class=\"table\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"col\">Username</th>\r\n");
      out.write("					<th scope=\"col\">Password</th>\r\n");
      out.write("					<th scope=\"col\">Fullname</th>\r\n");
      out.write("					<th scope=\"col\">Email</th>\r\n");
      out.write("					<th scope=\"col\">Role</th>\r\n");
      out.write("					<th scope=\"col\">Edit</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				");

				if (list != null) {
					for (User u : list) {
				
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>");
      out.print(u.getId());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(u.getPassword());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(u.getFullname());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(u.getEmail());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(u.getAdmin() ? "Admin" : "User");
      out.write("</td>\r\n");
      out.write("					<td><a href=\"");
      out.print(url);
      out.write("/labs5-ctl?edit=");
      out.print(u.getId());
      out.write("\">Edit</a>\r\n");
      out.write("						<a href=\"");
      out.print(url);
      out.write("/labs5-ctl?delete=");
      out.print(u.getId());
      out.write("\">Delete</a></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

				}
				}
				
      out.write("\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
