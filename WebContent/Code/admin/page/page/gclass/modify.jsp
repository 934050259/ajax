<%@page language="java" contentType="text/html; charset=UTF-8"
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
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品分类管理 &rarr; <span>商品分类管理</span>
	</div>
	<table class="table">
	<form action="gclassModifyAction.action" method="post" >
		<tr>
			<th align="center" colspan="2">商品分类管理</th>
		</tr>
	
		<tr>
			<input type="hidden" name="id" value="${gclass.id }" />
			<td>名字:</td>
			<td><input type="text" name="name" value="${gclass.name }"/></td>
			
		</tr>
		
	
		<tr>
			<td colspan="2">添加:<input type="submit"  value="修改"/></td>
		</tr>
	</form>
			
		
	</table>

	
</body>


</html>
