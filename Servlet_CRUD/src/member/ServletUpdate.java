package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "*****", "*****");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select  mname,email,cre_date from members where mno="+request.getParameter("mno"));
			rs.next();
			out.println("<html><head></head><body>");
			out.println("<form action='Update' method='post' >");
			out.println("회원번호 : <input type='text' name='mno' value='"+request.getParameter("mno")+"' readonly><br>");
			out.println("회원이름 : <input type='text' name='mname' value='"+rs.getString("mname")+"'><br>");
			out.println("이메일 : <input type='text' name='email' value='"+rs.getString("email")+"'><br>");
			out.println("가입일 : <input type='text' name='cre_date' value='"+rs.getString("cre_date")+"' readonly><br>");
			out.println("<input type='submit' value='수정' >");
			out.println("<input type='button' value='취소' onclick='location.href=\"List\"'>");
			out.println("<input type='button' value='삭제' onclick='location.href=\"Delete?mno="+request.getParameter("mno")+"\"'> ");
			out.println("</form></body></html>");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		request.setCharacterEncoding("UTF-8");
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "*****", "*****");
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
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}
}


