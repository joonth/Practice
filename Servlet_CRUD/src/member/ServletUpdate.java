package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/Update")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		Connection conn = (Connection) sc.getAttribute("conn");
		MemberDao dao = new MemberDao();
		dao.setConnection(conn);
		try {
			request.setAttribute("member", dao.getMemberInfo(Integer.parseInt(request.getParameter("mno"))));
			RequestDispatcher rd = request.getRequestDispatcher("form/UpdateForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		Connection conn = (Connection) sc.getAttribute("conn");
		MemberDao dao = new MemberDao();
		dao.setConnection(conn);
		Member member = new Member()
				.setMname(request.getParameter("mname"))
				.setEmail(request.getParameter("email"))
				.setMno(Integer.parseInt(request.getParameter("mno")));
		try {
			dao.updateMember(member);
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}


