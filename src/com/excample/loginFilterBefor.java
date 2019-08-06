package com.excample;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.excample.beanAndDao.Dao;
import com.excample.beanAndDao.admin;

public class loginFilterBefor implements Filter{

	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)req;

		httpRequest.setCharacterEncoding("UTF-8");
		
		String name = httpRequest.getParameter("name");
		String pwd = httpRequest.getParameter("pwd");
		String cod = httpRequest.getParameter("cod");
		
		HttpSession session = httpRequest.getSession();
		String nameFlag = (String)session.getAttribute("nameFlag");
		String pwdFlag = (String)session.getAttribute("pwdFlag");
		String code = (String)session.getAttribute("code");
		session.setMaxInactiveInterval(300);
		
		name=name==null?"":name;
		pwd=pwd==null?"":pwd;
		cod=cod==null?"":cod;
		nameFlag=nameFlag==null?"":nameFlag;
		pwdFlag=pwdFlag==null?"":pwdFlag;
		code=code==null?"":code;
		
		Boolean flag = false;
		for(admin user:admins) {
			if((name.equals(user.getName())&&pwd.equals(user.getPwd())&&cod.equals(code))||(nameFlag.equals(user.getName())&&pwdFlag.equals(user.getPwd()))){
				flag = true;
			}
		}
	
		if(flag){
			flag = false;
			session.removeAttribute("code");
			chain.doFilter(req, resp);
		}else {
			req.getRequestDispatcher("/Code/admin/login/login.jsp").forward(req, resp);
		}

	}
	
	private List<admin> admins;
	@Override
	public void init(FilterConfig config) throws ServletException {
		String sql = "select * from admin";
		admins = Dao.selectMore(admin.class, sql);
	}

}
