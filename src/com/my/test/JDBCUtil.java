package com.my.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	//���ݿ����ӳ�ֻ����ʼ��һ��
	public static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("myAjax"); 
	}
	
	//��������--�Ż�Ϊʹ��c3p0���ݳ�����
	public static Connection getMysqlConn() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//����쳣	���ر�����
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
			//Connection ����close�ǲ�����ֱ�ӹرգ����ǹ黹�����ݿ����ӳ�
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
			//Connection ����close�ǲ�����ֱ�ӹرգ����ǹ黹�����ݿ����ӳ�
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
			//Connection ����close�ǲ�����ֱ�ӹرգ����ǹ黹�����ݿ����ӳ�
			if (conn != null)
				conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
