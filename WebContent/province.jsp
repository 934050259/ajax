<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="jQuery-v1.12.4.js"></script>
<script type="text/javascript">
	$(function () {
		$("#province").change(function () {
			$("#city option:not(:first)").remove();
			//获取点击的provinceid
			var provinceid =$(this).val();
			//alert(provinceid);
			if(provinceid != ""){
				$("#show tr").remove();
				var url = "provinceServlet?method=cityList"
				var args = {"provinceid":provinceid,"time":new Date()};
				$.getJSON(url, args,function(data){
					//alert("当前省有"+data.length+"个城市");
					for(var i =0;i<data.length;i++){
						var city = data[i].city;
						var cityid = data[i].cityid;
						//alert(cityid);
						$("#city").append("<option value='"+cityid+"'>"+city+"</option>");
					}
					
				})			
			}
			
		});
		$("#city").change(function () {
			$("#area option:not(:first)").remove();
			//获取点击的cityid
			var cityid =$(this).val();
			//alert(cityid);
			if(cityid != ""){
				var url = "provinceServlet?method=areaList";
				//传入servlet的值
				var args = {"cityid":cityid,"time":new Date()};
				$("#show tr").remove();
				$("#show").append("<tr><th>areaid</th><th>area</th></tr>");	
				$.getJSON(url, args,function(data){
					//alert("当前城市有"+data.length+"个地区");
					for(var i =0;i<data.length;i++){
						var areaid = data[i].areaid;
						var area = data[i].area;
						
						$("#area").append("<option value='"+areaid+"'>"+area+"</option>");	
						$("#show").append("<tr><td>"+areaid+"</td><td>"+area+"</td></tr>");	
					}
					
				})			
			}
			
		});
		
	})
</script>
<body>
	<br>
	<br>
	<br>
	<br>
	<center>

		Province: <select id="province">
			<option value="">请选择...</option>
			<c:forEach items="${requestScope.provinces}" var="prov">
				<option value="${prov.provinceid }">${prov.province }</option>
			</c:forEach>
		</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		City: <select id="city">
			<option value="">请选择...</option>
		</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		Area: <select id="area">
			<option value="">请选择...</option>
		</select> <br>
		<br>

		<table id="show" border="1" cellpadding="5" cellspacing="0" style="">

		</table>

	</center>
</body>
</html>