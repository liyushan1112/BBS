package servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ITopicManager;
import managers.TopicManagerImpl;
import pojos.Topic;



/**
 * Servlet implementation class ReplytopicServlet
 */
public class ReplyTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("pid"));
		int sid =Integer.parseInt(request.getParameter("sid"));
		Topic topic=new Topic();
		topic.setTitle("");
		topic.setContent(request.getParameter("content"));
		Timestamp tt=new Timestamp(new java.util.Date().getTime());
		topic.setCreatDate(tt);
		topic.setIsLegal(0);
		topic.setUserid(Integer.parseInt((String) request.getSession().getAttribute("userid")));
		topic.setPid(id);
		topic.setSid(sid);
		
		ITopicManager manager = new TopicManagerImpl();
		manager.addTopic(topic);
		
		request.getRequestDispatcher("/ShowTopicAction?id="+id+"&sid="+3+"&currentPage="+1).forward(request, response);
	}

}
