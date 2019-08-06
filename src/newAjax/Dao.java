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
	   * ���ݵ���ɾ�Ĳ���
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
			System.out.println("�ɹ���");
		}
	}
	/**
	 * ��ѯ������¼
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
		//�õ���Ӧ����Ķ���
		T t = (T) clazz.newInstance();
		try {
			con = JDBCUtil.getMysqlConn();
			ps = con.prepareStatement(sql);
			//��mysql��䴫����
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();
			rsm = rs.getMetaData();
			// ��ȡ�����ֶ���(���ݱ��е�����)
			int count = rsm.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < count; i++) {
					// ���䷽��--��ȡÿ���ֶ��µ�����
					Field fd = clazz.getDeclaredField(rsm.getColumnName(i + 1));
					fd.setAccessible(true);
					// �����ݸ���Ӧ�������
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
	 * ��ѯ������¼
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
			//����sqlֵ
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();
			rsm = rs.getMetaData();
			// ��ȡ�෽��������
			int count = rsm.getColumnCount();
			while (rs.next()) {
				T t = (T) clazz.newInstance();	
				for (int i = 0; i < count; i++) {
					// ���䷽��--��ȡ�෽����
					Field fd = clazz.getDeclaredField(rsm.getColumnName(i + 1));
					//˽�еĲ���ֱ�ӷ���
					fd.setAccessible(true);
					// �����ݸ���Ӧ��
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
			// ��ȡ�෽��������
			int count = rsm.getColumnCount();
			while (rs.next()) {
				T t = (T) clazz.newInstance();	
				for (int i = 0; i < count; i++) {
					// ���䷽��--��ȡ�෽����
					Field fd = clazz.getDeclaredField(rsm.getColumnName(i + 1));
					//˽�еĲ���ֱ�ӷ���
					fd.setAccessible(true);
					// �����ݸ���Ӧ��
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
