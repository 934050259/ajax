package com.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class addToCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取请求参数：id,price
		String bookName = req.getParameter("id");
		int price = Integer.parseInt(req.getParameter("price"));
		// 2.获取购物车对象
		HttpSession session = req.getSession();
		ShopCart sc = (ShopCart) session.getAttribute("sc");
		if (sc == null) {
			sc = new ShopCart();
			session.setAttribute("sc", sc);
		}
		// 3.把点击的选项加入到购物车
		sc.addToCart(bookName, price);
		// 4.准备相应的JSON对象
		//如果从服务端返回JSON　字符串，则属性名必须是用双引号，转义字符"\""
		
/*		StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookname\":\"" + bookName+"\"")
			  .append(",")
			  .append("\"allBookNumber\":" + sc.getAllBookNumber())
			  .append(",")
			  .append("\"allBookPrice\":" + sc.getAllMoney())
			  .append("}");*/
		
		//使用jackson快速获取json字符串,获取到的是ShopCart中get方法的字段名
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(sc);
		//System.out.println(result);
		// 5.相应JSON对象
		resp.setContentType("text/javascript");
		resp.getWriter().print(result);

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}
