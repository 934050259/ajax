package com.excample;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.excample.beanAndDao.Dao;
import com.excample.beanAndDao.admin;
import com.excample.beanAndDao.gclass;
import com.excample.beanAndDao.goods;
import com.excample.beanAndDao.newGoods;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	public void showGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ѯ��Ʒ����������ںϵ�һ���µ�newgoods
		//��ȡ������������ͬ�ֶε�ֵ������޸����� AS ֻȡ�������һ��
		//String sql = "select goods.id,goods.name,goods.price,goods.image,goods.miaoshu,gclass.gname from goods,gclass where goods.gclass_id=gclass.id";
		//List<newGoods> newgoods = Dao.selectMore(newGoods.class, sql);
		
		//��ѯ������Ʒ����Ϊgclass_id
		String sql = "select id,name,price,image,miaoshu,gclass_id from goods ";
		List<goods> good = Dao.selectMore(goods.class, sql);
		
		//��ѯgclass_id���ϵ�session��
		List<gclass> gclas = Dao.selectMore(gclass.class, "select * from gclass");
		req.getSession().setAttribute("gclas", gclas);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String result = objectMapper.writeValueAsString(good);
		//System.out.println(result);
		resp .setContentType("text/javascript");
		resp.getWriter().print(result);
	}
	
	public void goodsDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodsId = req.getParameter("goodsId");
		String sql = "delete from goods where id = ?";
		Dao.update(sql, goodsId);
	}
	
	public void goodsModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String newprice = req.getParameter("price");
		//System.out.println(id+"   "+newprice);
		String sql = "update goods set price = ? where id = ?";
		Dao.update(sql,newprice,id);
		req.getRequestDispatcher("/Code/admin/page/page/goods/list.jsp").forward(req, resp);
	}
	
	public void goodsAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		goods good = new goods();
		try {
			boolean isMeltipart = ServletFileUpload.isMultipartContent(req);
			// �ж�ǰ̨��form�Ƿ���multipart����
			if (isMeltipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				// ����form���е����������ֶ�(name,score,testup)
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem file : items) {
					FileItem item = file;
					String itemName = item.getFieldName();
					String gname = "";
					String name = "";
					String image = "";
					String price = "";
					String miaoshu = "";
					// �ж�ǰ̨ form�Ƿ�Ϊ��ͨ�ֶ�
					// ȡֵ����Ϊitem.getString()
					if (item.isFormField()) {
						if (itemName.equals("gclass_id")) {
						    gname = item.getString("UTF-8");
						    System.out.println(gname);
						    good.setGclass_id(Integer.parseInt(gname));
						}else if (itemName.equals("name")) {
							name = item.getString("UTF-8");
							good.setName(name);
						}else if (itemName.equals("image")) {
							image = item.getString("UTF-8");
							good.setImage(image);
						}else if (itemName.equals("price")) {
							price = item.getString("UTF-8");
							good.setPrice(Double.parseDouble(price));
						}else if (itemName.equals("miaoshu")) {
							miaoshu = item.getString("UTF-8");
							good.setMiaoshu(miaoshu);
						}

					} else {
						// �ж�ǰ̨ form�Ƿ�Ϊ�ļ��ֶ�
						// getFiledName�ǻ�ȡ���ֶε�Nameֵ
						
						// getName�ǻ�ȡ�ϴ��ļ���
						String fileName = item.getName();//*.txt  *.png  *.docx
						//��ȡ�ļ���׺��
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png")||ext.equals("jpg"))){
								System.out.println("��ʽ����ֻ����png,jpg");
								return ;							
							}				
						// ��ȡ�ļ�����
						//System.out.println(fileName);
						// ��ȡ������·��
						//String path = req.getSession().getServletContext().getRealPath("upload");
						// �����ļ�·��:�ƶ��ϴ���λ��
						String path = "D:\\Eclipse\\ajax\\WebContent\\Code\\admin\\page\\page\\goods\\goodsimage";
						good.setImage(fileName);
						File file1 = new File(path, fileName);
						//������ʱ�ļ���С 40KB DiskFileItemFactory
						factory.setSizeThreshold(1024*40);
						factory.setRepository(new File("D:\\�½�"));//������ʱ�ļ�Ŀ¼λ��
						
						//�����ϴ��ļ��Ĵ�С 50KB  ServletFileUpload
						int size = 50;
						upload.setFileSizeMax(1024*size);//�ֽ�B											
						item.write(file1);// �ϴ�
						System.out.println(fileName+"�ϴ�ok");
					}
				}
			}else {
				System.out.println("error");
			}			
			String sql = "insert into goods(name,price,image,miaoshu,gclass_id) values(?,?,?,?,?)";
			//System.out.println(good);
			Dao.update(sql,good.getName(),good.getPrice(),"/goodsimage/"+good.getImage(),good.getMiaoshu(),good.getGclass_id());	
			req.getRequestDispatcher("/Code/admin/page/page/goods/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAdmins(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "select id,name,pwd,image from admin";
		List<admin> admins = Dao.selectMore(admin.class, sql);

		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(admins);
		//System.out.println(result);
		resp .setContentType("text/javascript");
		resp.getWriter().print(result);
	}
	public void adminAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		admin user = new admin();
		try {
			boolean isMeltipart = ServletFileUpload.isMultipartContent(req);
			// �ж�ǰ̨��form�Ƿ���multipart����
			if (isMeltipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				// ����form���е����������ֶ�(name,score,testup)
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem file : items) {
					FileItem item = file;
					String itemName = item.getFieldName();
					String name = null;
					String pwd = null;
					// �ж�ǰ̨ form�Ƿ�Ϊ��ͨ�ֶ�
					// ȡֵ����Ϊitem.getString()
					if (item.isFormField()) {
						if (itemName.equals("name")) {
						    name = item.getString("UTF-8");
						    user.setName(name);
						}else if (itemName.equals("pwd")) {
							pwd = item.getString("UTF-8");
							user.setPwd(pwd);
						}

					} else {
						// �ж�ǰ̨ form�Ƿ�Ϊ�ļ��ֶ�
						// getFiledName�ǻ�ȡ���ֶε�Nameֵ
						
						// getName�ǻ�ȡ�ϴ��ļ���
						String fileName = item.getName();//*.txt  *.png  *.docx
						//��ȡ�ļ���׺��
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png")||ext.equals("jpg"))){
								System.out.println("��ʽ����ֻ����png,jpg");
								return ;							
							}				
						// ��ȡ�ļ�����
						//System.out.println(fileName);
						// ��ȡ������·��
						//String path = req.getSession().getServletContext().getRealPath("upload");
						// �����ļ�·��:�ƶ��ϴ���λ��
						String path = "D:\\Eclipse\\ajax\\WebContent\\Code\\admin\\page\\page\\admin\\image";
						user.setImage(fileName);
						File file1 = new File(path, fileName);
						//������ʱ�ļ���С 40KB DiskFileItemFactory
						factory.setSizeThreshold(1024*40);
						factory.setRepository(new File("D:\\�½�"));//������ʱ�ļ�Ŀ¼λ��
						
						//�����ϴ��ļ��Ĵ�С 50KB  ServletFileUpload
						int size = 50;
						upload.setFileSizeMax(1024*size);//�ֽ�B											
						item.write(file1);// �ϴ�
						System.out.println(fileName+"�ϴ�ok");
					}
				}
			}else {
				System.out.println("error");
			}			
			String sql = "insert into admin(name,image,pwd) values(?,?,?)";
			Dao.update(sql, user.getName(),"/image/"+user.getImage(),user.getPwd());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void adminDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String sql = "delete from admin where name = ?";
		Dao.update(sql, name);
	}
	public void adminModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminId = req.getParameter("id");
		String newpwd = req.getParameter("newpwd");
		String sql = "update admin set pwd = ? where id = ?";
		Dao.update(sql, newpwd,adminId);
		req.getRequestDispatcher("/Code/admin/page/page/admin/modify.jsp").forward(req, resp);
	}
	public void checkpwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���������
		String pwd1 = req.getParameter("pwd1");
		//У�����֤��
		String pwd2 = req.getParameter("pwd2");
		pwd1 = pwd1==null?"":pwd1;
		pwd2 = pwd2==null?"":pwd2;
		String txt = "���벻һ��";
		if(!pwd1.equals(pwd2)) {
			req.getSession().setAttribute("txt", txt);
		}else {
			req.getSession().removeAttribute("txt");
		}
/*		resp.setContentType("text/html");
		resp.getWriter().print(result);*/

	}
	public void codecheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		//�������֤��
		String code1 = req.getParameter("code1");
		//��ʾ����֤��
		String code2 = (String) req.getSession().getAttribute("code");
		String txt = "��֤�����";
		if(!code1.equals(code2)) {
			req.getSession().setAttribute("codecheck", txt);
			//System.out.println(txt);
		}else {
			req.getSession().removeAttribute("codecheck");
		}


	}
}
