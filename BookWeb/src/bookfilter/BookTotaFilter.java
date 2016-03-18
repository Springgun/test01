package bookfilter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import jdbc.C3p0;

/**
 * Servlet Filter implementation class BookTotaFilter
 */
public class BookTotaFilter extends HttpFilter implements Filter {

   

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection conn = C3p0.getConnection();
		
		
		try {
			conn.setAutoCommit(false);
			
			chain.doFilter(request, response);
			
			conn.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}finally{
			C3p0.close();
		}
		
		
		
	}

	@Override
	public void init() {
		
		
	}

}
