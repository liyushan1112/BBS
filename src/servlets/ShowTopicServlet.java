package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.TopicManagerImpl;
import util.Page;



/**
 * Servlet implementation class ShowContentServlet
 */
public class ShowTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTopicServlet() {
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
		TopicManagerImpl manager = new TopicManagerImpl();
		int id = Integer.parseInt((String) request.getParameter("id"));
		
		int current = Integer.parseInt((String) request.getParameter("currentPage"));
		
		int row = manager.getTotalRow(id, 2);
		
		Page page = new Page(row,current,5);
		List<?> contentList = manager.queryOnePage(page,id);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("contentList", contentList);
		request.getSession().setAttribute("pid", id);
		request.getRequestDispatcher("/content.jsp").forward(request, response);
	}

}