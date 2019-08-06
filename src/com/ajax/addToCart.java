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
		// 1.��ȡ���������id,price
		String bookName = req.getParameter("id");
		int price = Integer.parseInt(req.getParameter("price"));
		// 2.��ȡ���ﳵ����
		HttpSession session = req.getSession();
		ShopCart sc = (ShopCart) session.getAttribute("sc");
		if (sc == null) {
			sc = new ShopCart();
			session.setAttribute("sc", sc);
		}
		// 3.�ѵ����ѡ����뵽���ﳵ
		sc.addToCart(bookName, price);
		// 4.׼����Ӧ��JSON����
		//����ӷ���˷���JSON���ַ���������������������˫���ţ�ת���ַ�"\""
		
/*		StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookname\":\"" + bookName+"\"")
			  .append(",")
			  .append("\"allBookNumber\":" + sc.getAllBookNumber())
			  .append(",")
			  .append("\"allBookPrice\":" + sc.getAllMoney())
			  .append("}");*/
		
		//ʹ��jackson���ٻ�ȡjson�ַ���,��ȡ������ShopCart��get�������ֶ���
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(sc);
		//System.out.println(result);
		// 5.��ӦJSON����
		resp.setContentType("text/javascript");
		resp.getWriter().print(result);

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}
