package BookServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Class<? extends BookServlet> clazz = this.getClass();
		
		String para = request.getParameter("method");
		
		Method method = null;
		
		try {
			method = clazz.getDeclaredMethod(para, HttpServletRequest.class, HttpServletResponse.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		method.setAccessible(true);
		try {
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
