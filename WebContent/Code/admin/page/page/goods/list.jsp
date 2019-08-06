<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ajax/Code/admin/page/main/css/right.css" rel="stylesheet" type="text/css" />
<script src="/ajax/js/jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var url = "/ajax/MyServlet?method=showGoods"; 
	var args = {
		"time" : new Date()
	};	
	$.getJSON(url, args, function(data) {
		for(var i =0;i<data.length;i++){
			$(".table").append("<tr><td align='center'>"+data[i].gclass_id+"</td>"+
			"<td align='center'>"+data[i].name+"</td>"+
			"<td align='center'><img src="+data[i].image+" style='width:100px;height:100px'/></td>"+
			"<td align='center'>"+data[i].price+"</td>"+
			"<td align='center'>"+data[i].miaoshu+"</td>"+
			"<td align='center'>"+
            "<a href='/ajax/Code/admin/page/page/goods/add.jsp'><div class='add' title='添加'></div></a>"+
            "<a href='modify.jsp?id="+data[i].id+"&price="+data[i].price+"'> <div class='modify' title='修改'></div></a>"+
            "<input type='hidden' value="+data[i].id+">"+
            "<div class='del' title='删除'></div>"+
            "</td></tr>");
		}	
	});
	$(".table").on('click', '.del', function() {
		var goodsId = $(this).prev().val();
  		var url = "/ajax/MyServlet?method=goodsDel"; 
		var args = {
			"time" : new Date(),
			"goodsId" : goodsId
		};	
		$.post(url, args);
		//刷新页面
		window.location.href="/ajax/Code/admin/page/page/goods/list.jsp"; 
	});
		
	
})
/* 	function search(){
		var name = document.getElementById("name").value;
		window.location.href="goodsListAction.action?name="+name;
	}
	function remove(id){
		if(window.confirm("你确定删除吗")){
			window.location.href="goodsRemoveAction.action?id="+id;
		}
	} */
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="name" type="text" value="${param.name }"/></div><div class="btn1" onclick="search()">查 找</div>
		
	</div>
	<table class="table">
	
		<tr>
		
			<th style="width:100px;">商品分类名字</th>
			<th style="width:150px;">商品名字</th>
			<th style="width:100px;">商品照片</th>
			<th style="width:100px;">商品价格</th>
			<th style="width:100px;">商品描述</th>
			<th style="width:100px;">操作</th>
		</tr>
   
<%-- 			 <tr>		
				<td align="center">${a.gname }</td>
				<td align="center">${a.name }</td>
				<td align="center"><img src="/goodsimage/1.jpg" style="width:100px;height:100px"/></td>
				<td align="center">${a.price }</td>
				<td align="center">${a.miaoshu }</td>
				<td align="center">
	            	<a href="goodsFindAllGclassAction.action"><div class="add"  title="添加"></div></a>
	               <a href="goodsFindByIdAction.action?id=${a.id }"> <div class="modify"  title="修改"></div></a>
	                <div class="del" onclick="remove(${a.id})"  title="删除"></div>
	            </td>
			</tr> --%>
	<!-- 	<tr>
			<td colspan="7" valign="middle" style="background:#F6F6F6">
			
			<j:navigator/>
			
			</td>
		</tr> -->
		
	</table>

	
</body>


</html>
