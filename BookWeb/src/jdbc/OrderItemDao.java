package jdbc;

import java.util.List;

import order.orderItem;

public class OrderItemDao extends BseaDao<orderItem> {
	
	public int saveOrderItem(orderItem orderItem){
		
		
		String  sql ="insert into bs_order_item (count ,amount ,title,author,price,img_path,order_id"
				+ ") values(?,?,?,?,?,?,?)";
		return this.Update(sql, orderItem.getCount(),orderItem.getAmount(),orderItem.getTitle(),
				orderItem.getAuthor(),orderItem.getPrice(),orderItem.getImg_Path(),orderItem.getOrderId()
				);
		
		
	}
	
	public  List<orderItem> getOrderItemList(String orderId){
		String sql ="select id,count,amount ,title,author,price,img_path img_Path,order_id orderId from "
				+ "bs_order_item where order_id=?";
		return this.QueryList(sql, orderId);
	}
	
	
	public void batchSaveOrderItem(Object [][] params){
		String  sql ="insert into bs_order_item (count ,amount ,title,author,price,img_path,order_id"
				+ ") values(?,?,?,?,?,?,?)";
		
		
		
		this.batch(sql, params);
		
	}
	
	public static void main(String [] args){
//		OrderItemDao dao = new OrderItemDao();
		
		//orderItem orderItem = new orderItem(null, 2,10, "茶花女", "大仲马",23,"/sda","145148809900346087351");
//		dao.saveOrderItem(orderItem);
		
//		List<orderItem> getrderItemList = dao.getrderItemList("145148809900346087351");
		
	}

}
