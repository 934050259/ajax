package com.excample.beanAndDao;

import java.util.List;

public class gclass {
	private int id;
	private String gname;

	@Override
	public String toString() {
		return "gclass [id=" + id + ", gname=" + gname + "]";
	}

	public gclass() {
		super();
	}

	public gclass(int id, String gname) {
		super();
		this.id = id;
		this.gname = gname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

/*	public static void main(String[] args) {
		List<gclass> gclas = Dao.selectMore(gclass.class, "select * from gclass");
		System.out.println(gclas);
	}*/

}
