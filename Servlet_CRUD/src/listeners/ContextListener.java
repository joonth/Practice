package listeners;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

import dao.MemberDao;
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
			MemberDao dao = new MemberDao();
			dao.setDbConnectionPool(connPool);
			sc.setAttribute("dao", dao);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
 

    public void contextDestroyed(ServletContextEvent event)  { 
    	connPool.closeAll();
    }

	
}
