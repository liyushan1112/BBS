package servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserListListener
 * 
 */
public class UserListListener implements ServletContextListener,
		ServletContextAttributeListener, HttpSessionListener,
		HttpSessionAttributeListener {

	private ServletContext application = null;
	private HttpSession session = null;

	public void contextInitialized(ServletContextEvent sce) {

		// ��ʼ��һ��application����
		this.application = sce.getServletContext();

		this.application.setAttribute("online", new ArrayList());
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void attributeAdded(ServletContextAttributeEvent scab) {

	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {

	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {

	}

	public void sessionCreated(HttpSessionEvent se) {

	}

	public void sessionDestroyed(HttpSessionEvent se) {


		List online = (List) this.application.getAttribute("online");

		String username = (String) se.getSession().getAttribute("name");

		online.remove(username);

		this.application.setAttribute("online", online);
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		

		List online = (List) this.application.getAttribute("online");

		String username = (String) se.getSession().getAttribute("name");
		if(!online.contains(username))
		{online.add(username);}
	
		this.application.setAttribute("online", online);
		this.application.setAttribute("size", online.size());
		
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {

	}
}
