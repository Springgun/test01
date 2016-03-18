package BookServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookService.BookService;
import book.BS_Book;
import pages.Page;

public class BookClientServlet extends BookServlet{

	
	/**
	 * @return
	 */

	private static final long serialVersionUID = 1L;
	
	protected void findBook(HttpServletRequest request,HttpServletResponse response) {
		BookService service=new BookService();
		
		String number = request.getParameter("pageNumber");
		
		int pageSize =4;
		
		Page<BS_Book> page =service.findBook(number,pageSize);
		
		request.setAttribute("page", page);
		
		String uri = request.getRequestURI();
		
		String query = request.getQueryString();
		
		if(query.contains("&pageNumber")){
			
			query = query.substring(0, query.indexOf("&pageNumber"));
		}
		
		uri=uri+"?"+query;
		
		request.setAttribute("pagePage", uri);
		
		try {
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			
			
			e.printStackTrace();
		}
	
	}
	
	

	protected void  orderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
	}

}
