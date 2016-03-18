package BookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OrderService.OrderService;
import User.User;
import cartitem.Cart;
import dispose.OperateUser;
import order.Order;
import order.orderItem;

/**
 * Servlet implementation class OrderClientServlet
 */
public class OrderClientServlet extends BookServlet {
	private static final long serialVersionUID = 1L;
	
	
	private String str= getStr();
			
	public String getStr(){
		
		System.out.println("---------------------------xxxx----------------");
		return "aa";
	}
			
			
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void checkout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService =new OrderService();

		HttpSession session = request.getSession();
		// 被OperateUser包裹的User
		OperateUser user = (OperateUser) session.getAttribute("username");

//		if (user == null) {
//			request.setAttribute("tag", "该操作需要登入账号");
//
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//		} else {
			Cart cart = (Cart) session.getAttribute("cart");

			if (cart == null) {
				
				response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
				
			}else{
			String OrderId = orderService.CreateOrder(cart, user.getUser());
		
			request.setAttribute("orderId", OrderId);
			session.removeAttribute("cart");

			request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);

		}
	}
//	}

	protected void orderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService =new OrderService();

		HttpSession session = request.getSession();
		OperateUser user = (OperateUser) session.getAttribute("username");

//		if (user == null) {
//			request.setAttribute("tag", "该操作需要登入账号");
//
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//		} else {
			List<Order> list = orderService.getOrderListByUserId(user.getUser().getId() + "");
			if (list == null) {
				System.out.println("yes");
			} else {
				for (Order order : list) {
					System.out.println(order);
				}
			}

			request.setAttribute("list", list);

			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);

		}

//	}

	
	protected void orderInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService =new OrderService();

		HttpSession session = request.getSession();
		 
		
		OperateUser user=(OperateUser)session.getAttribute("username");
//		if(user == null){
//			request.setAttribute("tag", "该操作需要登入账号");
//			
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//		}else{
			
			
			String orderId = request.getParameter("orderId");
			
			
			List<orderItem> orderItemList = orderService.getOrderItemList(orderId);
			
			
			request.setAttribute("list",orderItemList);
			
			request .getRequestDispatcher("/pages/order/order-info.jsp").forward(request, response);
		
			
		}
		
//	}
	
	

	protected void takeBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	OrderService orderService =new OrderService();

		
		String orderId = request.getParameter("orderId");
		
		orderService.takeBook(orderId);
		
		response.sendRedirect(request.getContextPath()+"/OrderClientServlet?method=orderList");
	}

}
