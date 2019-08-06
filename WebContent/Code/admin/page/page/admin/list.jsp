<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<html>
<head>
<title>管理员管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ajax/Code/admin/page/main/css/right.css" rel="stylesheet" type="text/css" />
<script src="/ajax/js/jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 	var url = "/ajax/MyServlet?method=showAdmins"; 
	var args = {
		"time" : new Date()
	};	
	$.getJSON(url, args, function(data){
		for(var i =0;i<data.length;i++){
			//alert(data[i].image);
			$(".table").append("<tr><td align='center'>"+data[i].name+"</td>"+
					"<td align='center'><img src="+data[i].image+" style='width:100px;height:100px;'></td>"+
					"<td align='center'>"+
		            "<a href='add.jsp'><div class='add'  title='添加'></div></a>"+
		            "<a href='modify.jsp?id="+data[i].id+"&pwd="+data[i].pwd+"'> <div class='modify'  title='修改'></div></a>"+
		            "<div class='del' title='删除'></div></td></tr>");
		}
	});
	
	$(".table").on('click', '.del', function() {
		var name = $(this).parent().prev().prev().text();
 		var url = "/ajax/MyServlet?method=adminDel"; 
		var args = {
			"time" : new Date(),
			"name" : name
		};	
		$.post(url, args);
		//刷新页面
		window.location.href="/ajax/Code/admin/page/page/admin/list.jsp";
	});
	
})
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="email" type="text" value="${param.email }"/></div><div class="btn1" onclick="search()">查 找</div>
		
	</div>
	<table class="table">

		<tr>

			<th style="width:150px;">账号</th>
			<th style="width:100px;">一寸艳照</th>
			<th style="width:100px;">操作</th>
		</tr>
        
		
<%--   		 <tr>		 
			<td align="center"></td>
			<td align="center"><img src="/image/2.jpg" style="width:100px;height:100px;"></td>
			<td align="center">
            	<a href="add.jsp"><div class="add"  title="添加"></div></a>
                <a href="modify.jsp?id="> <div class="modify"  title="修改"></div></a>
                <div class="del"   title="删除"></div>
                <td colspan="5" valign="middle" style="background:#F6F6F6">
            </td>
		</tr>    --%> 
		
			
<!-- 		<tr>
			<td colspan="5" valign="middle" style="background:#F6F6F6">
				
			</td>
		</tr> -->
		
	</table>

	
</body>


</html>
