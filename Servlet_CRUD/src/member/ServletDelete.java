package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;


@WebServlet("/Delete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		Connection conn = (Connection)  sc.getAttribute("conn");
		MemberDao dao = new MemberDao();
		dao.setConnection(conn);
		try {
			dao.deleteMember(Integer.parseInt(request.getParameter("mno")));
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
