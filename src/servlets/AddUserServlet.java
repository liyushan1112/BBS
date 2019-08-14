package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IUserManager;
import managers.UserManagerImpl;
import pojos.User;


/**
 * Servlet implementation class addUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
	 *doPost���� 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user=new User();

		user.setPassword(request.getParameter("password"));
		user.setUserName(request.getParameter("username"));
		user.setRealname(request.getParameter("realname"));
		user.setSex(request.getParameter("sex"));
		user.setTel(request.getParameter("tel"));
		user.setFavorite(request.getParameter("favorite"));
		user.setHome(request.getParameter("home"));

		IUserManager manager = new UserManagerImpl();
		
		manager.register(user);
		
		
		request.getRequestDispatcher("/login").forward(request, response);
	}

}
