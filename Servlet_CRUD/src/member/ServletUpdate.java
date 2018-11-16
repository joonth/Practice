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
import javax.servlet.http.HttpSession;

import dao.OracleMemberDao;
import vo.Member;


@WebServlet("/Update")
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member smember =(Member)session.getAttribute("smember");
		if(smember != null) {
			Member member = (Member)request.getAttribute("member");
			ServletContext sc = request.getServletContext();
			OracleMemberDao dao = (OracleMemberDao) sc.getAttribute("dao");
			try {
				if(member != null) {
					dao.updateMember(member);
					request.setAttribute("viewUrl", "redirect:List.do");
				}else {
					request.setAttribute("member", dao.getMemberInfo(String.valueOf(request.getAttribute("mno"))));
					request.setAttribute("viewUrl", "form/UpdateForm.jsp");
				}				
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}else {
			request.setAttribute("viewUrl", "redirect:form/LoginForm.jsp");
		}
	}
}


