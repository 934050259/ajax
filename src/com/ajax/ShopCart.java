package com.ajax;

import java.util.HashMap;
import java.util.Map;

public class ShopCart {
	// Map存放 K：书名 V：书的对象
	private Map<String, ShopBookBean> items = new HashMap<String, ShopBookBean>();
	
	private String bookName ;

	public void addToCart(String bookName, int price) {
		
		this.bookName = bookName;
		
		if (items.containsKey(bookName)) {
			ShopBookBean book = items.get(bookName);
			book.setNumber(book.getNumber() + 1);

		} else {
			ShopBookBean book = new ShopBookBean(1, bookName, price);
			items.put(bookName, book);

		}

	}
	public String getBookName() {
		return bookName;
	}
	
	public int getAllBookNumber() {
		int all = 0;
		for(ShopBookBean book:items.values()) {
			all += book.getNumber();
		}
		return all;		
	}
	
	public int getAllBookPrice() {
		int all = 0;
		for(ShopBookBean book:items.values()) {
			all += book.getPrice()*book.getNumber();
		}
		return all;		
	}


}
