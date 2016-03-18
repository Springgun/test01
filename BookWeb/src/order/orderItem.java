package order;

public class orderItem {
	
	
	private Integer id;
	private int count;
	private double amount;
	private String title;
	private String author;
	private double price;
	private String img_Path;
	private String orderId;
	
	

	public orderItem(Integer id, int count, double amount, String title, String author, double price, String img_Path,
			String orderId) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.title = title;
		this.author = author;
		this.price = price;
		this.img_Path = img_Path;
		this.orderId = orderId;
	}
	
	
           

	public orderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public int getCount() {
		return count;
	}





	public void setCount(int count) {
		this.count = count;
	}





	public double getAmount() {
		return amount;
	}





	public void setAmount(double amount) {
		this.amount = amount;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public double getPrice() {
		return price;
	}





	public void setPrice(double price) {
		this.price = price;
	}





	public String getImg_Path() {
		return img_Path;
	}





	public void setImg_Path(String img_Path) {
		this.img_Path = img_Path;
	}





	public String getOrderId() {
		return orderId;
	}





	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
