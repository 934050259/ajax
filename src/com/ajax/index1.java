package com.ajax;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class index1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		List<String> names = Arrays.asList("aaa","bbb","ccc");
		String name = req.getParameter("name");
		String result = null;
		if(names.contains(name)) {
			result  ="<font color='red'>该用户已存在</font>";
		}else {
			result  ="<font color='green'>该用户可以使用</font>";
		}
		resp.setContentType("text/html");
		resp.getWriter().print(result);
	}

}
