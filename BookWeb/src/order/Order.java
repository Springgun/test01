package order;

import java.util.Date;

public class Order {
	private String id;
	
	private Date orderTime;
	
	private int totalCount;
	
	private int state;
	
	private double totalAmount;
	
	private int userID;
	
	
	
	
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	







	public Order(String id, Date orderTime, int totalCount, int state, double totalAmount, int userID) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.totalCount = totalCount;
		this.state = state;
		this.totalAmount = totalAmount;
		this.userID = userID;
	}









	public String getId() {
		return id;
	}









	public void setId(String id) {
		this.id = id;
	}









	public Date getOrderTime() {
		return orderTime;
	}









	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}









	public int getTotalCount() {
		return totalCount;
	}









	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}









	public int getState() {
		return state;
	}









	public void setState(int state) {
		this.state = state;
	}









	public double getTotalAmount() {
		return totalAmount;
	}









	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}









	public int getUserID() {
		return userID;
	}









	public void setUserID(int userID) {
		this.userID = userID;
	}









	public static void main(String[] args) {
		

	}

}
