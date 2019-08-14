package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.TopicManagerImpl;
import pojos.Topic;


/**
 * Servlet implementation class ShowSectionServlet
 */
public class ShowSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = Integer.parseInt((String) request.getParameter("sid"));
		System.out.println(sid);
		TopicManagerImpl manager = new TopicManagerImpl();
		List<Topic> allContent=manager.queryAll(sid);
		request.getSession().setAttribute("allContent", allContent);
		request.getSession().setAttribute("sid", sid);
		request.getRequestDispatcher("section.jsp").forward(request, response);
	}

}
