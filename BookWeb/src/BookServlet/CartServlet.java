package BookServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import BookService.BookService;
import book.BS_Book;
import cartitem.Cart;

public class CartServlet extends BookServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();

	}

	protected void add2Cart(HttpServletRequest request, HttpServletResponse response) {
		BookService service = new BookService();
		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();

			session.setAttribute("cart", cart);
		}

		String bookId = request.getParameter("bookId");

		BS_Book book = service.query(bookId);

		session.setAttribute("title", book.getTitle());

		cart.addBook2Cart(book);

		String header = request.getHeader("referer");

		try {
			response.sendRedirect(header);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	protected void clear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {

		} else {
			cart.clear();
		}

		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void delbook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("bookId");
		
		HttpSession session = request.getSession();
		
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart==null){
			
		}else{
			cart.delCartItem(id);
		}
		
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		
	}
	

	protected void updateCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id  = request.getParameter("bookId");
		
		String number= request.getParameter("count");
		
		HttpSession session = request.getSession();
		
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart ==null){
			
		}else{
			cart.updateCount(id, number);
		}
		
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}

}
