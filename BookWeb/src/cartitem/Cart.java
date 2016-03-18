package cartitem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import book.BS_Book;

public class Cart implements Serializable {
	/*
	 * ±£´æ¹ºÎïÏî
	 */
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();

	private int totalCount;
	private double totalAmount;
	private List<CartItem> cartItem;

	public List<CartItem> getCartItem() {
		Collection<CartItem> values = map.values();
		return new ArrayList<CartItem>(values);
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public int getTotalCount() {

		int totalCount = 0;
		List<CartItem> cartItems = getCartItem();
		for (CartItem cartItem : cartItems) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	public double getTotalAmount() {
		BigDecimal totalAmount = new BigDecimal("0");
		List<CartItem> cartItems = getCartItem();
		for (CartItem cartItem : cartItems) {
			totalAmount = totalAmount.add(new BigDecimal(cartItem.getAmount() + ""));
		}
		// System.out.println(totalAmount.doubleValue());
		return totalAmount.doubleValue();
	}

	public void addBook2Cart(BS_Book book) {
		CartItem cartItems = map.get(book.getId() + "");
		if (cartItems != null) {
			int count = cartItems.getCount();
			cartItems.setCount(count+1);

		} else {
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			map.put(book.getId() + "", cartItem);
		}
	}

	public void delCartItem(String bookId) {
		map.remove(bookId);
	}

	public void clear() {
		map.clear();
	}

	public void updateCount(String bookId, String countStr) {
		CartItem cartItem = map.get(bookId);
		try {
			int count = Integer.parseInt(countStr);
			cartItem.setCount(count);
		} catch (Exception e) {

		} finally {

		}
	}

	public Cart() {
		super();
	}

}
