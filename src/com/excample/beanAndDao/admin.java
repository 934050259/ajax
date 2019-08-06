package com.excample.beanAndDao;

import java.util.List;

public class admin {
	private int id ;
	private String name;
	private String pwd;
	private String image;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public admin(int id, String name, String pwd, String image) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.image = image;
	}
	public admin() {
		super();
	}
	@Override
	public String toString() {
		return "admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", image=" + image + "]";
	}
/*	public static void main(String[] args) {
		String sql = "select * from admin";
		List<admin> admins = Dao.selectMore(admin.class, sql);

	}*/
}
