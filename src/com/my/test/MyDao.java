package com.my.test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import newAjax.JDBCUtil;

public class MyDao {
	public static <T> List<T> selectMore(Class<T> clazz, String sql)  {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsm = null;
		List<T> list = new ArrayList<T>();
		try {
			con = JDBCUtil.getMysqlConn();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			rsm = rs.getMetaData();
			// 获取类方法名个数
			int count = rsm.getColumnCount();
			while (rs.next()) {
				T t = (T) clazz.newInstance();	
				for (int i = 0; i < count; i++) {
					// 反射方法--获取类方法名
					Field fd = clazz.getDeclaredField(rsm.getColumnName(i + 1));
					//私有的不能直接访问
					fd.setAccessible(true);
					// 传数据给相应类
					fd.set(t, rs.getObject(i + 1));
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.ConnectionClose(rs, con, ps);
		}
		return list;
	}
	public static void main(String[] args) {
		String sql = "select name from beauty";
		List<beauty> beautys = MyDao.selectMore(beauty.class, sql);
		System.out.println(beautys);
	}
}
