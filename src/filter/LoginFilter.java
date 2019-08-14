package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest htreq = (HttpServletRequest) request;
		HttpServletResponse htres = (HttpServletResponse) response;
		PrintWriter out = htres.getWriter();
		if(htreq.getSession().getAttribute("user")==null) {
			out.println("<center>您还没有登录，请先登录，页面将在三秒后跳转</center>");
			htres.setHeader("refresh", "3;login.jsp");
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
