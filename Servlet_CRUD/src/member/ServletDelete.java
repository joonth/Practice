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


@WebServlet("/Delete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			stmt = conn.createStatement();
			stmt.executeQuery("delete members where mno="+request.getParameter("mno"));
			
			stmt1 = conn.createStatement();
			stmt1.executeQuery("update members set mno=mno-1 where mno >"+request.getParameter("mno"));
			
			response.sendRedirect("List");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs!=null)rs.close();}catch(Exception e) {}
			try {if(stmt!=null)stmt.close();}catch(Exception e) {}
			try {if(stmt1!=null)stmt1.close();}catch(Exception e) {}
			try {if(conn!=null)conn.close();}catch(Exception e) {}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
