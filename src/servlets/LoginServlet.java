package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.IUserManager;
import managers.UserManagerImpl;



/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		RequestDispatcher rd;
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		IUserManager manager = new UserManagerImpl();
	
		String info = manager.login(username, pass);
		
		if(info!=null){
			System.out.println("ok");
			String id = info.split("#")[0];
			String isAdmin = info.split("#")[1];
			
			HttpSession session = request.getSession(true);
			session.setAttribute("name", username);
			session.setAttribute("userid", id);
			session.setAttribute("isAdmin", isAdmin);
			
			if(isAdmin.equals("0")){
				request.getRequestDispatcher("/BBS/QueryAllAction").forward(request, response);}
			
			else{
				request.getRequestDispatcher("/adminPortail.jsp").forward(request, response);}
		
		}else{
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
	}

}
