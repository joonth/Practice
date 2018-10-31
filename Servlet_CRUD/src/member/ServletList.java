package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/List")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			pstmt = conn.prepareStatement("select mno,mname,email,cre_date from members order by mno asc");
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<a href='Add'>[회원추가]</a><br>");
			while(rs.next()) {
				out.println(rs.getInt("mno")+","
								+"<a href='Update?mno="+rs.getInt("mno")+"'>"+rs.getString("mname")+"</a>,"
								+rs.getString("email")+","
								+rs.getDate("cre_date")+"<a href='Delete?mno="+rs.getInt("mno")+"'>[삭제]</a><br>");
			}
			out.println("</body></html>");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
