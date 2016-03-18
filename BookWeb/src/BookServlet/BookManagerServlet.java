package BookServlet;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.runtime.ProtectedFunctionMapper;

import com.sun.org.apache.regexp.internal.REUtil;

import BookService.BookService;
import book.BS_Book;
import pages.Page;

public class BookManagerServlet extends BookServlet {


	public BookManagerServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) {
		BookService service = new BookService();
		System.out.println("添加");
		Map map = request.getParameterMap();
		System.out.println(map);
		BS_Book book=new BS_Book();
//	 
		try {
			BeanUtils.populate(book, map);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println(service.add(book));
		try {
			response.sendRedirect(request.getContextPath()+"/manager?method=getList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
//	protected void getList(HttpServletRequest request, HttpServletResponse response){
//		System.out.println("列表");
//		
//		List<BS_Book> bookList = service.getBookList();
//		for (BS_Book bs_Book : bookList) {
//			System.out.println(bs_Book);
//		}
//		
//		request.setAttribute("BookList", bookList);
//		try {
//			request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	protected void delbook(HttpServletRequest request, HttpServletResponse response) {
		BookService service = new BookService();
		System.out.println("删除图书");
		String bookId = request.getParameter("id");
		System.out.println(service.del(bookId));
		try {
			response.sendRedirect(request.getContextPath()+"/manager?method=getList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	protected void findBook(HttpServletRequest request,HttpServletResponse response){
		String number = request.getParameter("pageNumber");
		BookService service = new BookService();
		int pageSize =4;
		Page<BS_Book> findBook = service.findBook(number, pageSize);
		request.setAttribute("page",findBook);
		
		try {
			request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	


	

}
