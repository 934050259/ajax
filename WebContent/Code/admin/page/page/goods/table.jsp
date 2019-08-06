<!DOCTYPE html>
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script src="../../../../../jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var url = "/ajax/MyServlet?method=showGoods"; 
	var args = {
		"time" : new Date()
	};
	
	$.getJSON(url, args, function(data) {
		for(var i =0;i<data.length;i++){
			$("#goods").append("<tr><td align='center'>"+data[i].id+"</td>"+
								"<td align='center'>"+data[i].name+"</td>"+
								"<td align='center'><div class='add' title='添加'></div>"+
								"<div class='modify'  title='修改'></div><div class='el' title='删除'></div></td><tr>");
		}	
	});
	
	$(".table").on('click', '.modify', function() {
		var id = $(this).parent().prev().prev().text();
		alert(id);
/* 		var url = "/ajax/MyServlet?method=update"; 
		var args = {
			"time" : new Date()
		};
		$.getJSON(url, args, function(data) {
			for(var i =0;i<data.length;i++){
	
			}	
		}); */
	});

	
	
})
</script> 
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="name" type="text" value=""/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="add()">添加</div>
	</div>
	
	<table class="table" id="goods">
		<tr>
			<th style="width:50px;">ID</th>
			<th style="width:150px;">商品名称</th>
			<th style="width:100px;">操作</th>
		</tr>

<!-- 		<tr>
			<td colspan="5" valign="middle" style="background:#F6F6F6">
				
			</td>
		</tr> -->
	</table>

	
</body>


</html>
