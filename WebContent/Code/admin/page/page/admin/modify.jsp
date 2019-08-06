<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://www.666666.com" prefix="j" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	input {width:500px;}
</style>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<form action="/ajax/MyServlet?method=adminModify" method="post">
	<table class="table">
		
			<tr>
				<!-- <th style="width:20px;">密码重置123456</th> -->
				<td>重置密码：<input type="text" name="newpwd" value="<%=request.getParameter("pwd")%>"/></td>
				<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
			</tr>

			<tr>
				<td colspan="5" valign="middle" style="background:#F6F6F6">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		
	</table>
	</form>
	
</body>


</html>
