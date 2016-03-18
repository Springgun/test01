package jdbc;

import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import order.Order;

public class OrderDao extends BseaDao<Order> {

	public int saveOrder(Order order) {
		String sql = "insert into bs_order(id, order_time ,total_count,total_amount,state ,user_id) values(?,?,?,?,?,?)";
		return this.Update(sql, order.getId(), order.getOrderTime(), order.getTotalCount(), order.getTotalAmount(),
				order.getState(), order.getUserID());

	}

	public List<Order> getOrderList(String userID) {
		String sql = "select id ,order_time orderTime,total_count totalCount,total_amount totalAmount,state ,user_id userID from bs_order where user_id=?";
		return this.QueryList(sql, userID);
	}

	public int updateOrderState(String orderId, int state) {
		String sql = "update bs_order set state=? where id=?";
		return this.Update(sql, state, orderId);
	}

	public List<Order> getOrderList() {
		String sql = "select id ,order_time orderTime , total_count totalCount ,total_amount totalAmount ,state ,user_id userID from bs_order";
		return this.QueryList(sql);
	}
	
	public static void main(String[] args){
//		OrderDao orderDao = new OrderDao();
//		int userID=46087351;
//		String id =System.currentTimeMillis()+""+userID;
//		Order order =new Order(id,new Date(),2,20,0,userID);
//	System.out.println( orderDao.saveOrder(order));
//		
//		List<Order> List = orderDao.getOrderList();
//		for (Order order : List) {
//			System.out.println(order);
//		}
		
//		List<Order> List = orderDao.getOrderList(userID+"");
//		System.out.println(List);
		
//		
//		int update = orderDao.updateOrderState("145148809900346087351",3);
//		System.out.println(update);
		
		
		
	}

}
