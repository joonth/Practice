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

import vo.Member;


@WebServlet("/Update")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno,mname,email,cre_date from members where mno="+request.getParameter("mno"));
			rs.next();
			Member member = new Member()
					.setMno(rs.getInt("mno"))
					.setMname(rs.getString("mname"))
					.setEmail(rs.getString("email"))
					.setCre_date(rs.getDate("cre_date"));
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("form/UpdateForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			pstmt = conn.prepareStatement("update members set mname = ? , email = ? , mod_date = sysdate where mno="+request.getParameter("mno"));
			pstmt.setString(1, request.getParameter("mname"));
			pstmt.setString(2, request.getParameter("email"));
			pstmt.executeQuery();
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
		}
	}
}


