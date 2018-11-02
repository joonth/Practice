package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("form/LoginForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc =this.getServletContext();
		Connection conn = (Connection)sc.getAttribute("conn");
		MemberDao dao = new MemberDao();
		dao.setConnection(conn);
		try {
			Member member =dao.login(request.getParameter("email"), request.getParameter("pwd"));
			if(member != null) {
				response.sendRedirect("List");
			}else {
				response.sendRedirect("Login");
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
