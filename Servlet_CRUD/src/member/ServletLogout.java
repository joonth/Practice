package member;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/Logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member smember =(Member)session.getAttribute("smember");
		if(smember != null) {
			request.getSession().invalidate();
			request.setAttribute("viewUrl", "redirect:form/LoginForm.jsp");
		}else {
			request.setAttribute("viewUrl", "redirect:form/LoginForm.jsp");
		}
	}
}
