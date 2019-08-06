<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品分类管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function search(){
		var name = document.getElementById("name").value;
// 		alert(name);
		window.location.href="gclassListAction.action?name="+name;
	}
	function remove(id){
		if(window.confirm("你确认删除吗?")){
			
			window.location.href="gclassRemoveAction.action?id="+id;
		}
		
	}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品分类管理 &rarr; <span>商品分类管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="name" type="text" value="${param.name }"/></div><div class="btn1" onclick="search()">查 找</div>
		
	</div>
	<table class="table">

		<tr>

			<th style="width:150px;">商品分类名字</th>
			<th style="width:100px;">操作</th>
		</tr>
		
		<c:forEach items="${list }" var="a">
		 <tr>
			<td align="center">${a.name }</td>
			<td align="center">
            	<a href="add.jsp"><div class="add"  title="添加"></div></a>
               <a href="gclassFindByIdAction.action?id=${a.id }"> <div class="modify"  title="修改"></div></a>
                <div class="del" onclick="remove(${a.id});"  title="删除"></div>
            </td>
		<tr>
	</c:forEach>
	
	
		<tr>
			<td colspan="5" valign="middle" style="background:#F6F6F6">
			
			<j:navigator/>
			
			</td>
		</tr>
		
	</table>

	
</body>


</html>
