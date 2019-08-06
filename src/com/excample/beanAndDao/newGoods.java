package com.excample.beanAndDao;

import java.util.List;

public class newGoods {
	private int id;
	private String name;
	private double price;
	private String image;
	private String miaoshu;
	private String gname;
	public newGoods(int id, String name, double price, String image, String miaoshu, String gname) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.miaoshu = miaoshu;
		this.gname = gname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public String getgname() {
		return gname;
	}
	public void setgname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return "newGoods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", miaoshu="
				+ miaoshu + ", gname=" + gname + "]";
	}
	public newGoods() {
		super();
	}

	public static void main(String[] args) {
		//Dbutils 不支持别名幅值
		String sql2 = "select goods.name as name,gclass.name as gname from goods,gclass where goods.gclass_id=gclass.id";
		List<newGoods> newgoods = Dao.selectMore(newGoods.class, sql2);
		System.out.println(newgoods);
	}
}
