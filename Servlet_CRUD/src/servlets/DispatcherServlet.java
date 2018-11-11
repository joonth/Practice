package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		
		try {
			String pageControllerPath = null;
			
			if("/List.do".equals(servletPath)) {
				pageControllerPath = "List";
			
			
			}else if("/Add.do".equals(servletPath)) {
				pageControllerPath = "Add";
				if(request.getParameter("email") != null) {
					request.setAttribute("member", new Member()
							.setEmail(request.getParameter("email"))
							.setPwd(request.getParameter("pwd"))
							.setMname(request.getParameter("mname")));
				}
			}
			
			else if("/Update.do".equals(servletPath)) {
				pageControllerPath = "Update";
				
				if(request.getParameter("fmno") != null) {
					request.setAttribute("mno", request.getParameter("fmno"));					
				}
				
				if(request.getParameter("email") != null) {
					request.setAttribute("member", new Member()
							.setMno(Integer.parseInt(request.getParameter("mno")))
							.setMname(request.getParameter("mname"))
							.setEmail(request.getParameter("email")));
				}
			}
			
			
			else if("/Delete.do".equals(servletPath)) {
				pageControllerPath = "Delete";
			}
			
			else if("/Login.do".equals(servletPath)) {
				System.out.println("통과");
				pageControllerPath = "Login";
				if(request.getParameter("email") !=null) {
					request.setAttribute("member", new Member()
							.setEmail(request.getParameter("email"))
							.setPwd(request.getParameter("pwd")));
				}
			}
			
			else if("/Logout.do".equals(servletPath)) {
				pageControllerPath = "Logout";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(pageControllerPath);
			rd.include(request, response);
			
			String viewUrl =(String) request.getAttribute("viewUrl");
			if(viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			}else {
				rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			/*request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);*/
		}
	}

}
