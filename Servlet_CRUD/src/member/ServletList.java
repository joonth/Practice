package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;


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
			rs = pstmt.executeQuery();
			List<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
						.setMno(rs.getInt("mno"))
						.setMname(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCre_date(rs.getDate("cre_date")));
			}
			request.setAttribute("members", members);
			RequestDispatcher rd = request.getRequestDispatcher("form/ListForm.jsp");
			rd.forward(request, response);
		
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(pstmt != null) pstmt.close();}catch(Exception e) {}
		}
	}
}
