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
        <div style="float: left; padding-left: 25px;">
            <p>角色id: ${role.roleId}</p>
            <p>角色名: ${role.roleName}</p>
        </div>
        <div style="float: left; margin-left: 25px; height: 400px; overflow:auto;">
            <form method="post" class="form-x" action="<%=basePath%>roleController/updateRoleMenu.do">
                <input type="hidden" name="roleId" value="${role.roleId}"/>
                <div class="form-group" id="checkboxlist">
                    <c:forEach items="${menuList}" var="menu">
                        <p><input type="checkbox" name="menuId" value="${menu.menuId}"/>${menu.anthortyName}</p>
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
<script>
    $(function(){
        var list = ${roleMenuIdListJson};
        $("#checkboxlist input").each(function(){
            for(var i in list){
                if(this.value == list[i]){
                    this.setAttribute("checked", "checked");
                }
            }
        });
    });
</script>
</html>