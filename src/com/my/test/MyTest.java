package com.my.test;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyTest extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String method = req.getParameter("method");
		try {
			Method declaredMethod = getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			declaredMethod.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void start(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, AWTException {
		String sql = "select name from beauty";
		List<beauty> beautys = MyDao.selectMore(beauty.class, sql);
		//beauty beauty = beautys.get(new Random().nextInt(beautys.size()));	
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(beautys);
		
		//System.out.println(result);
		//…Ë÷√œ‘ æ—” ±
        //Robot r  =  new  Robot(); 
        //r.delay(200);   
		resp .setContentType("text/javascript");
		resp.getWriter().print(result);
	}
	public void stop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}

}
