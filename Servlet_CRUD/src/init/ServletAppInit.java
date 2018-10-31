package init;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/ServletAppInit")
public class ServletAppInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletAppInit init....");
		super.init(config);
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("username"), sc.getInitParameter("password"));
			sc.setAttribute("conn", conn);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	public void destroy() {
		System.out.println("ServletAppInit destroy....");
		super.destroy();
		Connection conn = (Connection) this.getServletContext().getAttribute("conn");
		try {if(conn != null && conn.isClosed() == false) {conn.close();}}catch(Exception e) {}
	}

}
