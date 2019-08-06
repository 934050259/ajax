<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOP</title>
 <link href="css/main.css" rel="stylesheet" type="text/css" /> 
</head>
<script type="text/javascript">
		setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
</script> 
<body>
	<div id="top">
		<div id="logo"></div>
		<div id="user">【欢迎您】：${sessionScope.nameFlag }【IP】：admin【今天】：</div>
		<div id="time"></div>		
	</div>
</body>
</html>
