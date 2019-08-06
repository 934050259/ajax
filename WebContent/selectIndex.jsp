<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var sh;
	var flag = 0;
	var beautys;
	var url = "MyTest?method=start";
	var args = {
		"name" : name,
		"time" : new Date()
	};
	$.getJSON(url, args, function(data) {
		beautys = new Array(data.length);
		for(var i =0;i<data.length;i++){
			beautys[i] = data[i].name;	
			//alert(beautys[i]);
		}
	});
	
	function run() {
		var rand = parseInt(Math.random()*(beautys.length));
		//alert(rand);
		$("#in").val(beautys[rand]); 		
	};
	
	$("#b1").click(function(){
		flag++;
		if(flag == 1){
			$("#b1").text("暂停抽奖");
			sh = setInterval(run,50);
		}
		if(flag == 2){
			window.clearInterval(sh);			
			$("#b1").text("开始抽奖"); 
			flag = 0;
		}
	});
		
})
</script>
<body>
	<h1 align="center" style="color:red">xxxx年度庆典</h1>
	<br>
	<br>
	<h2 align="center" style="color:red">恭喜下面这位</h2>
	<br>
	<br>
	<div align="center">
		中奖者:<input type="text" id="in" align="middle" name="name"><br><br>
		&nbsp;&nbsp;&nbsp;
		<button id="b1">开始抽奖</button>

	</div>
	
	
</body>
</html>