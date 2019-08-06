package com.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String date = req.getParameter("date");
		String regex  = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|\r\n" + 
				"((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|\r\n" + 
				"((0[48]|[2468][048]|[3579][26])00))-02-29)$";
		String result = null;
		//System.out.println(date.matches(regex));
		//判断日期格式
		if(!date.matches(regex)) {
			result  ="<font color='red'>"+date+"日期格式错误</font>";
		}else {
			result  ="<font color='green'>"+date+"日期格式正确</font>";
		}
		resp.setContentType("text/html");
		resp.getWriter().print(result);
	}
}
