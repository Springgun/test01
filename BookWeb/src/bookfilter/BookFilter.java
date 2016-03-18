package bookfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dispose.OperateUser;

/**
 * Servlet Filter implementation class BookFilter
 */
public class BookFilter extends HttpFilter  {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		
		OperateUser user = (OperateUser) session.getAttribute("username");
		
		if(user==null){
			request.setAttribute("tag", "该操作需要登入账号");

			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init() {
		
		
	}


 



}
