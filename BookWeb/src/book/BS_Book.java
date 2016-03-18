package book;

import java.io.Serializable;

public class BS_Book implements Serializable{
	private Integer id;
	private String title;
	private String author;
	private Double price;
	private Integer sales;
	private Integer stock;
	private String img_path="/static/img/default.jpg";
	
	public BS_Book() {
		super();
	}

	public BS_Book(Integer id, String title, String author, Double price, Integer sales, Integer stock,
			String img_path) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.img_path = img_path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@Override
	public String toString() {
		return "BS_Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", sales=" + sales
				+ ", stock=" + stock + ", img_path=" + img_path + "]";
	}
	
	
	
	
	
	

}
