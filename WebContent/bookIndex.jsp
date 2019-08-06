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
		var isHasCart="${sessionScope.sc == null}";
		//没有选择书籍时隐藏提示框
		if(isHasCart == "true"){
			$("#cartstatus").hide();			
		}else{
			$("#cartstatus").show();
		}
		
		$("a").click(function () {
			$("#cartstatus").show();
			var url = this.href;
			var args = {"time":new Date()};
			$.getJSON(url,args,function(data){
				$("#bookname").text(data.bookname);
				$("#allBookNumber").text(data.allBookNumber);
				$("#allBookPrice").text(data.allBookPrice);			
			});
			return false;
		});
	})		

</script>
<body>
	<div id = "cartstatus"> 
		您已经将&nbsp;<span id = "bookname"></span>&nbsp;加入到购物车。
		购物车中有&nbsp;<span id = "allBookNumber"></span>&nbsp;本。
		总价钱&nbsp;<span id = "allBookPrice"></span>&nbsp;。
	</div>
	<br><br>
	Java &nbsp; &nbsp; <a href="addToCart?id=Java&price=100">加入购物车</a><br>
	MySql &nbsp; &nbsp; <a href="addToCart?id=MySql&price=200">加入购物车</a><br>
	ST2 &nbsp; &nbsp; <a href="addToCart?id=ST2&price=150">加入购物车</a><br>


</body>
</html>