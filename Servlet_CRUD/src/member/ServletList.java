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
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/List")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member smember =(Member)session.getAttribute("smember");
		if(smember != null) {
			ServletContext sc = this.getServletContext();
			MemberDao dao = (MemberDao)sc.getAttribute("dao");
			try {
				request.setAttribute("members", dao.getList());
				request.setAttribute("viewUrl", "form/ListForm.jsp");
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}else {
			request.setAttribute("viewUrl", "redirect:form/LoginForm.jsp");
		}
	}
}
