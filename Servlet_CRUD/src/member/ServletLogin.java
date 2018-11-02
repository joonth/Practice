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
		Connection conn =(Connection) this.getServletContext().getAttribute("conn"); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select mno,mname,email from members where email=? and pwd=?");
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("pwd"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Member member=new Member()
						.setMno(rs.getInt("mno"))
						.setMname(rs.getString("mname"))
						.setEmail(rs.getString("email"));
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("List");
			}else {
				response.sendRedirect("Login");
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
		
		}
	}

}
