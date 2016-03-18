package BookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OrderService.OrderService;
import order.Order;

/**
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BookServlet {
	private static final long serialVersionUID = 1L;
	
	
	 

    /**
     * Default constructor. 
     */
    public OrderManagerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService =new OrderService();
		List<Order> orderLIst = orderService.getOrderLIst();
		
		request.setAttribute("list", orderLIst);
		
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		
		
	}
	
	

	protected void sendBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService =new OrderService();
		String orderId = request.getParameter("orderId");
		orderService.sendBook(orderId);
		response.sendRedirect(request.getContextPath()+"/OrderManagerServlet?method=orderList");
	}
		
	
	
	

}
