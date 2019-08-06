package com.excample.beanAndDao;

import java.util.List;

public class goods {
	private int id;
	private String name;
	private double price;
	private String image;
	private String miaoshu;
	private int gclass_id;
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
	public int getGclass_id() {
		return gclass_id;
	}
	public void setGclass_id(int gclass_id) {
		this.gclass_id = gclass_id;
	}
	public goods(int id, String name, double price, String image, String miaoshu, int gclass_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.miaoshu = miaoshu;
		this.gclass_id = gclass_id;
	}
	public goods() {
		super();
	}
	@Override
	public String toString() {
		return "goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", miaoshu=" + miaoshu
				+ ", gclass_id=" + gclass_id + "]";
	}
	public goods(String name, double price, String image, String miaoshu, int gclass_id) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.miaoshu = miaoshu;
		this.gclass_id = gclass_id;
	}
/*	public static void main(String[] args) {
		goods good = new goods("qqq",12321,"aa","nnn",1);
		String sql = "insert into goods(name,price,image,miaoshu,gclass_id) values(?,?,?,?,?)";

		Dao.update(sql, good.getName(),good.getPrice(),"/goodsimage/"+good.getImage(),good.getMiaoshu(),good.getGclass_id());	
		
		System.out.println(good);
	}*/

}
