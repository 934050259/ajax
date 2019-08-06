<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset rows="*" cols="188,*" framespacing="0" frameborder="no" border="0">
		<frame src="left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame"/>
		<frameset rows="35,*" cols="*">
		  <frame src="right_top.jsp" name="mainFrame" id="mainFrame" scrolling="no"/>
		  <frame src="right.jsp" name="right"/>
		</frameset>
	 </frameset>
</frameset>
	
<noframes>
	<body>
		<%
			String nameFlag  = (String)request.getParameter("name");
			session.setAttribute("nameFlag", nameFlag);
			String pwdFlag  = (String)request.getParameter("pwd");
			session.setAttribute("pwdFlag", pwdFlag);
			session.removeAttribute("checkcode");
		%>
	</body>
</noframes>
</html>
