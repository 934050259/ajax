package com.ajax;

public class ShopBookBean {
	private int number;
	private String bookName;
	private int price;
	public ShopBookBean() {
		super();
	}
	public ShopBookBean(int number, String bookName, int price) {
		super();
		this.number = number;
		this.bookName = bookName;
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
