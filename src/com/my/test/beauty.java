package com.my.test;


//表结构和类对应
public class beauty {
	private String name;  
	
	public beauty(String name) {
		super();
		this.name = name;
	}

	public beauty() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "beauty [name=" + name + "]";
	}
	




}
