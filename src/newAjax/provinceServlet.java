package newAjax;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class provinceServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String method1 = req.getParameter("method");	
		try {
			//�÷����ȡJSP���صķ�����ִ��
			Method method2 = getClass().getMethod(method1, HttpServletRequest.class,HttpServletResponse.class);
			method2.invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void provinceList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String sql = "select provinceid,province from provinces;";
		List<province> provinces = Dao.selectMore(province.class, sql);
		req.setAttribute("provinces", provinces);		
		req.getRequestDispatcher("/province.jsp").forward(req, resp);
	}
	
	public void cityList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//��ȡ�����provinceid����ѯ��Ӧ������
		String provinceid = req.getParameter("provinceid");
		String sql = "select cityid,city from cities c where c.provinceid = ?";
		List<city> cities = Dao.selectMore(city.class,sql,provinceid);
		ObjectMapper objectMapper = new ObjectMapper();
		//System.out.println(cities);
		//ʹ��jackson����ȡ���ݵ�JSON���� {"city":city,"cityid":cityid}
		String result = objectMapper.writeValueAsString(cities);
		//System.out.println(result);
		
		resp .setContentType("text/javascript");
		resp.getWriter().print(result);
	}
	
	public void areaList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//��ȡ�����cityid����ѯ��Ӧ���س���
		String cityid = req.getParameter("cityid");
		String sql = "select areaid,area from areas a where a.cityid = ?";
		List<area> areas = Dao.selectMore(area.class,sql,cityid);
		ObjectMapper objectMapper = new ObjectMapper();
		//System.out.println(areas);
		//ʹ��jackson����ȡ���ݵ�JSON���� {"area":area,"areaid":areaid}
		String result = objectMapper.writeValueAsString(areas);
		//System.out.println(result);
		
		resp .setContentType("text/javascript");
		resp.getWriter().print(result);
		
	}
	
	
	
	
	
	
	
	
	
	
}
