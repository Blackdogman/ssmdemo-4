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
	<h1>添加用户</h1>
	<hr>
	<form action="<%=basePath%>userController/addUser.do" method="post">
		<span style="color:red;">${addErrorMessage}</span>
		<table>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td><input type="text" name="hobby" /></td>
			</tr>
			<tr>
				<td>登录名:</td>
				<td><input type="text" name="loginName" /></td>
			</tr>
			<tr>
				<td><button type="submit">添加</button></td>
				<td><button type="reset">重置</button></td>
			</tr>
		</table>
	</form>
</body>
</html>