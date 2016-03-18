package cartitem;

import java.io.Serializable;
import java.math.BigDecimal;

import book.BS_Book;

public class CartItem implements Serializable {
	private BS_Book book;
	private double amount;
	private int count;

	public BS_Book getBook() {
		return book;
	}

	public void setBook(BS_Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		// System.out.println("amount"+amount);
		// System.out.println("count"+count);
		amount = (new BigDecimal(count).multiply(new BigDecimal(book.getPrice()))).doubleValue();
		return amount;
	}

	public CartItem() {
		super();

	}

}
