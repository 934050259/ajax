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
	$(function(){
		$(":input[name='name']").change(function () {
			var val = $(this).val();
			val = $.trim(val);
			if(val!=""){
				var url ="index1";
				var args = {"name":val,"time":new Date()};
				$.post(url,args,function(data){
					$("#message").html(data);					
				});				
			}		
		});
	})		

</script>
<body>
	<form action="" method="post">
		用户名：<input type="text" name="name"><br>
		<dir id="message"></dir>
		 <input type="submit" value="登入"><br>
<!--  	<img style="width:100px;height:100px;" src="/image/1.jpg"> -->


	</form>


</body>
</html>