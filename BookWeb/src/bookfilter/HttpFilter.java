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


public abstract class HttpFilter implements Filter {
	
	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest Sr=(HttpServletRequest)arg0;
		HttpServletResponse sres=(HttpServletResponse) arg1;
		doFilter(Sr, sres, arg2);

	}
	
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException ;

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config=arg0;
		init();
	}
	
	
	public abstract void init();
	
	
	public FilterConfig getConfig(){
		return config;
	}
	
	

}
