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

@WebServlet("/Add")
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body><h1>회원추가</h1>");
		out.println("<form action='Add' method='post'>");
		out.println("이름 : <input type='text' name='mname'><br>");
		out.println("비밀번호 : <input type='password' name='pwd'><br>");
		out.println("이메일 : <input type='text' name='email'><br>");
		out.println("<input type='submit' value='추가' >");
		out.println("<input type='button' value='취소' onclick='location.href=\"List\"' >");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mno from members order by mno desc");
			rs.next();
			int lastMno = rs.getInt("mno")+1;
			
			pstmt = conn.prepareStatement("insert into members (mno,mname,pwd,email,cre_date,mod_date) values (?,?,?,?,sysdate,sysdate)");
			pstmt.setInt(1, lastMno);
			pstmt.setString(2, request.getParameter("mname"));
			pstmt.setString(3, request.getParameter("pwd"));
			pstmt.setString(4, request.getParameter("email"));
			pstmt.executeQuery();
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
		}
	}

}
