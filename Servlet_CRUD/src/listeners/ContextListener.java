package listeners;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

import context.ApplicationContext;
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
	static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public void contextInitialized(ServletContextEvent event)   { 
		try {
			ServletContext sc = event.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			applicationContext = new ApplicationContext(propertiesPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
 

    public void contextDestroyed(ServletContextEvent event)  { 
    }

	
}
