<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<link href="/ajax/Code/admin/login/images/login.css" rel="stylesheet" type="text/css" />
<script src="/ajax/js/jQuery-v1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$("#cod").change(function () {
			var val = $(this).val();
			val = $.trim(val);
			if(val!=""){
				var url ="/ajax/MyServlet?method=codecheck";
				var args = {"code1":val,"time":new Date()};
				$.post(url,args,function(data){
					this.location.href="login.jsp";				
				});				
			}		
		});
	})		

</script>
</head>
<body>
<%
	String flag = request.getParameter("flag");
	if(flag!=null&&flag.equals("true")){
		session.removeAttribute("nameFlag");
		session.removeAttribute("pwdFlag");
	}
%>

    <div id="login">
    
	     <div id="top">
		      <div id="top_left"><img src="/ajax/Code/admin/login/images/login_03.gif"  /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			  
			  <form action="/ajax/Code/admin/page/main/main.jsp" method="post">
			       <div id="user">账号：
			         <input type="text" name="name" id="em"/>
			       </div>
				   <div id="password">密 码：
				     <input type="password" name="pwd" id="pwd"/>
				   </div>
				   <div id="code">验证码：
				     <input type="text" name="cod" id="cod"  />			     
				   </div>	   
				   <div id="btn">
				  		
						<img alt="请等待..." src="/ajax/ValidateColorServlet">
						<input type="submit" value="登录">
						<a href="reg.html" type="">注册</a>
							<%String ckc = (String)session.getAttribute("codecheck"); %>
						<font color='red'><%=ckc==null?"":ckc %></font>
							<%session.removeAttribute("codecheck"); %>
						<!-- <a href="../page/main/main.jsp">登录</a>
						<a href="reg.html" type="">注册</a> -->
				   </div>
				</form>  
				
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		
		 
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">中软创新综合管理系统 2015 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center">			  
			  	<a href="forget.html">忘记密码！</a>
			  </div>		 
		 </div>
	</div>
</body>
</html>
