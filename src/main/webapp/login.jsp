<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录</h1>
<hr>
<form action="userController/login.do" method="post">
<table>
	<tr>
		<td colspan="2">
			<span style="color:red;">${ loginErrorMessage }</span>
		</td>
	</tr>
	<tr>
		<td>用户名：</td>
		<td><input type="text" name="loginName" /></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr>
		<td><button type="submit" >登录</button></td>
	</tr>
</table>
</form>
</body>
</html>