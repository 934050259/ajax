package newAjax;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	/**
	   * 数据的增删改操作
	 * 
	 */
	public static void update(String sql, Object... obj) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getMysqlConn();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.ConnectionClose(ps, con);
			System.out.println("成功！");
		}
	}
	/**
	 * 查询单条记录
	 * @param <T>
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 */
	public static <T> T selectOne(Class clazz, String sql, Object... obj) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsm = null;
		//得到相应的类的对象
		T t = (T) clazz.newInstance();
		try {
			con = JDBCUtil.getMysqlConn();
			ps = con.prepareStatement(sql);
			//向mysql语句传参数
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();
			rsm = rs.getMetaData();
			// 获取表中字段数(数据表中的列数)
			int count = rsm.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < count; i++) {
					// 反射方法--获取每个字段下的数据
					Field fd = clazz.getDeclaredField(rsm.getColumnName(i + 1));
					fd.setAccessible(true);
					// 传数据给相应类的属性
					fd.set(t, rs.getObject(i + 1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.ConnectionClose(rs, con, ps);
		}
		return t;
	}
	/**
	 * 查询多条记录
	 * @param <T>
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 */
	public static <T> List<T> selectMore(Class<T> clazz, String sql, Object... obj)  {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsm = null;
		List<T> list = new ArrayList<T>();
		try {
			con = JDBCUtil.getMysqlConn();
			ps = con.prepareStatement(sql);
			//传入sql值
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
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
/*	public static void main(String[] args) {
		String sql = "select cityid,city from cities c where c.provinceid = ?";
		List<city> cityid = Dao.selectMore(city.class, sql,130000);
		System.out.println(cityid);
	}*/
}
