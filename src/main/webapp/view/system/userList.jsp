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
<h1>用户列表</h1>
<a href="<%=basePath%>view/system/userAdd.jsp">增加用户</a>
<hr>
<table border="1">
	<tr>
		<th>用户ID</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>性别</th>
		<th>爱好</th>
		<th>用户名</th>
		<th>创建时间</th>
		<th colspan="2">操作</th>
	</tr>
	<c:if test="${empty userList != true }">
		<c:forEach var="item" items="${userList}">
				<tr>
					<td>${item.userId }</td>
					<td>${item.name }</td>
					<td>${item.age }</td>
					<td>${item.sex }</td>
					<td>${item.hobby }</td>
					<td>${item.loginName }</td>
					<td>${item.createTime }</td>
					<td><a href="<%=basePath%>userController/deleteUser.do?userId=${item.userId }">删除！</a></td>
					<td><a href="<%=basePath%>userController/updateUserUi.do?userId=${item.userId }">修改！</a></td>
				</tr>
		</c:forEach>
	</c:if>
	
</table>
</body>
</html>