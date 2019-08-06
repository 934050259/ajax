<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	input {width:500px;}
</style>
<script src="../../../../../jQuery-v1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$("#check1").change(function () {
			var pwd1 = $(this).val();
			var pwd2 = $("#check2").val();
		
			if(pwd1!=""){
				var url ="/ajax/MyServlet?method=checkpwd";
				var args = {"pwd1":pwd1,"pwd2":pwd2,"time":new Date()};
				$.post(url,args,function(data){
					//如果两次输入的密码不一致，则刷新页面不提交，且提示密码不一致
					window.location.href="add.jsp";
				});				
			}		
		});
	})		

</script>

</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	
<form action="/ajax/MyServlet?method=adminAdd" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th align="center" colspan="2">管理员管理</th>
		</tr>
	
		<tr>
			
			<td>账号:</td>
			<td><input type="text" name="name" value=""/></td>
			
		</tr>
		<tr>
			<td>艳照:</td>
			<td><input type="file" name="image" value=""/></td>
			
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="pwd" value="" id="check2"/></td>
		</tr>
		<tr>
			<td>密码确认:</td>
			<!-- 设置提示信息跳出当前页面时失效：缓存效果 -->
			<%String ckc = (String)session.getAttribute("txt"); %>
			<td><input type="password" name="pwd1" value="" id="check1"/><font color='red'><%=ckc==null?"":ckc %></font></td>
			<%session.removeAttribute("txt"); %>
		</tr>
		<tr>
			<td colspan="2">添加:<input type="submit"  value="添加"/><font color="red">${error }</font></td>
		</tr>
	</table>
</form>
			
		


	
</body>


</html>
