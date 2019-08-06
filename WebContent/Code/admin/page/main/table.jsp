<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/right.css" rel="stylesheet" type="text/css" />
<script src="../../../../jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	
	
	
})		
</script>
</head>

<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 用户信息 &rarr; <span>文件管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="name" type="text" value=""/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="add()">添加</div>
	</div>
	<table class="table">
		<tr>
        	<th style="width:50px;" ><div class="del_t" title="删除"></div><a href="#">反选</a></th>
			<th style="width:50px;">ID</th>
			<th style="width:150px;">文件名称</th>
			<th style="width:100px;">文件类型</th>
			<th>文件描述</th>
			<th style="width:100px;">操作</th>
		</tr>
		<!-- 
		<tbody id="data">
			<tr><td colspan="5" align="center"><div class="tb_loading"></div></td></tr>
		</tbody>
		-->
		<tr>
        	<td align="center"><input type="checkbox" value=""></td>
			<td align="center">1</td>
			<td align="center">C:/fdsa/txt</td>
			<td align="center">数据库</td>
			<td align="center">数据库文件</td>
			<td align="center">
            	<div class="add" title="添加"></div>
                <div class="modify" title="修改"></div>
                <div class="del" title="删除"></div>
            </td>
		<tr>
        
        <tr>
        	<td align="center"><input type="checkbox" value=""></td>
			<td align="center">1</td>
			<td align="center">C:/fdsa/txt</td>
			<td align="center">数据库</td>
			<td align="center">数据库文件</td>
			<td align="center">
            </td>
		<tr>		
		<tr>
			<td colspan="6" valign="middle" style="background:#F6F6F6"><div id="jpage" class="jpage"></div></td>
		</tr>
	</table>

	
</body>


</html>
