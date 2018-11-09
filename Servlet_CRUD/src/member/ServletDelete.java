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
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/Delete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member =(Member)session.getAttribute("member");
		if(member != null) {
			ServletContext sc = this.getServletContext();
			MemberDao dao = (MemberDao)sc.getAttribute("dao");
			try {
				dao.deleteMember(Integer.parseInt(request.getParameter("mno")));
				response.sendRedirect("List");
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}else {
			response.sendRedirect("Login");
		}
	}
}
