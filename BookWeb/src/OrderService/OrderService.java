package OrderService;

import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import User.User;
import book.BS_Book;
import cartitem.Cart;
import cartitem.CartItem;
import jdbc.BookDao;
import jdbc.OrderDao;
import jdbc.OrderItemDao;
import order.Order;
import order.orderItem;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	private OrderItemDao itemDao = new OrderItemDao();
	private BookDao bookdao = new BookDao();

	public String CreateOrder(Cart cart, User user) {
		int id = user.getId();
		String orderId = System.currentTimeMillis() + "" + id;
		int totalCount = cart.getTotalCount();
		double totalAmount = cart.getTotalAmount();

		Order order = new Order(orderId, new Date(), totalCount, 0, totalAmount, id);
		orderDao.saveOrder(order);

		List<CartItem> cartItems = cart.getCartItem();
		
		
		
		Object [][] itemParams =new Object [cartItems.size()][];
		 Object [][] bookParams=new Object[cartItems.size()][];
		 int i=0;
		for (CartItem cartItem : cartItems) {
			int count = cartItem.getCount();

			double amount = cartItem.getAmount();

			BS_Book book = cartItem.getBook();

			String title = book.getTitle();
			String author = book.getAuthor();
			Double price = book.getPrice();
			String img_path = book.getImg_path();
			Integer sales = book.getSales();
			Integer stock = book.getStock();

//			orderItem orderItem = new orderItem(null, count, amount, title, author, price, img_path, orderId);

//		itemDao.saveOrderItem(orderItem);

			
			itemParams[i]=new Object[]{count, amount, title, author, price, img_path, orderId};
		
//			book.setSales(sales + count);
//			book.setStock(stock - count);
//
//		bookdao.update(book);
			
			bookParams[i]=new Object[]{
					sales+count,stock-count,book.getId()
			};

			i++;
			

		}
//		for (Object[] objects : bookParams) {
//			for (Object object : objects) {
//				System.out.print(object + " ");
//			}
//		}
	
		itemDao.batchSaveOrderItem(itemParams);
		bookdao.batchUpdat(bookParams);
		
	//cart.clear();
		
		
		
		return orderId;

	}
	
	
	public List<Order> getOrderListByUserId(String userId){
		return orderDao.getOrderList(userId);
	}
	
	
	
	public List<orderItem> getOrderItemList(String orderId){
		
		
		return itemDao.getOrderItemList(orderId);
		
	}
	public List<Order> getOrderLIst(){
		return orderDao.getOrderList();
	}
	
	
	public void sendBook(String orderId){
		orderDao.updateOrderState(orderId,1);
	}
	
	public void takeBook(String orderId){
		orderDao.updateOrderState(orderId, 2);
	}

}
