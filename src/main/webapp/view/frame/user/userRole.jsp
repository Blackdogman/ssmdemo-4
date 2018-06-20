<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>分配权限</strong></div>
    <div class="body-content">
        <div style="float: left;">
            <p>用户id: ${user.userId}</p>
            <p>用户名: ${user.userName}</p>
        </div>
        <div style="float: left; margin-left: 25px;">
            <form method="post" class="form-x" action="<%=basePath%>userRoleController/updateUserRole.do">
                <input type="hidden" name="userId" value="${user.userId}"/>
                <div class="form-group">
                    <c:forEach items="${roleList}" var="role">
                        <p><input type="checkbox" name="roleId" value="${role.roleId}"/>${role.roleName}</p>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <button type="submit" class="button">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>