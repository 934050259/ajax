package com.my.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	//数据库连接池只被初始化一次
	public static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("myAjax"); 
	}
	
	//配置连接--优化为使用c3p0数据池连接
	public static Connection getMysqlConn() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//检测异常	，关闭连接
	public static void ConnectionClose(ResultSet rs ,Connection conn ,PreparedStatement ps1) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			if (ps1 != null)
				ps1.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			//Connection 对象close是并不是直接关闭，而是归还给数据库连接池
			if (conn != null)
				conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public static void ConnectionClose(ResultSet rs ,Connection conn ) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			//Connection 对象close是并不是直接关闭，而是归还给数据库连接池
			if (conn != null)
				conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	public static void ConnectionClose(PreparedStatement ps1 ,Connection conn ) {
		try {
			if (ps1 != null)
				ps1.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			//Connection 对象close是并不是直接关闭，而是归还给数据库连接池
			if (conn != null)
				conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
