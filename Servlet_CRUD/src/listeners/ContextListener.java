package listeners;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

import controls.MemberAddController;
import controls.MemberDeleteController;
import controls.MemberListController;
import controls.MemberLoginController;
import controls.MemberLogoutController;
import controls.MemberUpdateController;
import dao.OracleMemberDao;
import util.DBConnectionPool;


@WebListener
public class ContextListener implements javax.servlet.ServletContextListener {
	DBConnectionPool connPool ;
	
	public void contextInitialized(ServletContextEvent event)   { 
		try {
			ServletContext sc = event.getServletContext();
			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			OracleMemberDao dao = new OracleMemberDao();
			dao.setDbConnectionPool(connPool);
			
			sc.setAttribute("/Login.do", new MemberLoginController().setMemberDao(dao));
			sc.setAttribute("/List.do", new MemberListController().setMemberDao(dao));
			sc.setAttribute("/Update.do", new MemberUpdateController().setMemberDao(dao));
			sc.setAttribute("/Delete.do", new MemberDeleteController().setMemberDao(dao));
			sc.setAttribute("/Add.do", new MemberAddController().setMemberDao(dao));
			sc.setAttribute("/Logout.do", new MemberLogoutController());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
 

    public void contextDestroyed(ServletContextEvent event)  { 
    	connPool.closeAll();
    }

	
}
