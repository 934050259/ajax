<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="js/jQuery-v1.12.4.js"></script>
<script type="text/javascript">
$(function () {
	$("#Date").change(function () {
		var date = $(this).val();
		var url = "Test1";
		var args = {"date":date,"time":new Date()};
		if(date!=""){
			$.post(url, args,function(data){
				$("#message").html(data);	
			});	
		}
	});
		
})
</script>
<body>

	<form action="" method="post">
		Bitrh date(yyyy-MM-dd):<input type="text" name="name" id="Date"><br><br>
		<dir id="message"></dir>

	</form>
</body>
</html>