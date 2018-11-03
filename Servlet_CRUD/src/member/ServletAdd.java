package member;

import java.io.IOException;
import java.io.PrintWriter;
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
import vo.Member;

@WebServlet("/Add")
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("form/AddForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		Connection conn =(Connection) sc.getAttribute("conn");
		MemberDao dao = new MemberDao();
		dao.setConnection(conn);
		Member member = new Member()
				.setMname(request.getParameter("mname"))
				.setEmail(request.getParameter("email"))
				.setPwd(request.getParameter("pwd"));
		try {
			dao.addMember(member);
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
