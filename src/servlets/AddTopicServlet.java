package servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.*;
import pojos.Topic;


/**
 * Servlet implementation class AddTopicServlet
 */
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicServlet() {
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
		
		Topic Topic=new Topic();
		Topic.setTitle(request.getParameter("title"));
		Topic.setContent(request.getParameter("content"));
		Timestamp tt=new Timestamp(new java.util.Date().getTime());
		Topic.setCreatDate(tt);
		Topic.setIsLegal(0);
		Topic.setUserid(Integer.parseInt((String) request.getSession().getAttribute("userid")));
		Topic.setPid(0);
		Topic.setSid(Integer.parseInt(request.getParameter("sid")));
		
		ITopicManager manager = new TopicManagerImpl();
		manager.addTopic(Topic);
			
		request.getRequestDispatcher("ShowSectionAction").forward(request, response);
		
		
	}

}
