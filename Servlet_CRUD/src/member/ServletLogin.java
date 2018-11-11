package member;

import java.io.IOException;
import java.sql.Connection;


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
  
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		ServletContext sc = this.getServletContext();
		MemberDao dao = (MemberDao)sc.getAttribute("dao");
		try {
			if(request.getAttribute("member") != null) {
				Member member =dao.login((Member)request.getAttribute("member"));
				request.getSession().setAttribute("member", member);
				System.out.println("not null");
				request.setAttribute("viewUrl", "redirect:List.do");
			}else {
				System.out.println("null");
				request.setAttribute("viewUrl", "redirect:form/LoginForm.jsp");
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
