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
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <a href="<%=basePath%>view/frame/role/roleAdd.jsp" class="button border-blue" id=""><span
                            class="icon-plus"></span> 添加
                    </a>
                    <button type="button" class="button border-green" id="checkall"><span class="icon-check"></span> 全选
                    </button>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">角色ID</th>
                <th>roleName</th>
                <th>roleDesc</th>
                <th>roleState</th>
                <th>createTime</th>
                <th>操作</th>
            </tr>
            <c:forEach var="role" items="${roleList}">
                <tr>
                    <td><input type="checkbox" name="id[]" value="1"/>
                            ${role.roleId}
                    </td>
                    <td>${role.roleName}</td>
                    <td>${role.roleDesc}</td>
                    <td>${role.roleState}</td>
                    <td><fmt:formatDate value="${role.createTime}" type="both"/></td>
                    <td>
                        <div class="button-group">
                            <a class="button border-red"
                               href="<%=basePath%>roleController/deleteRole.do?roleId=${role.roleId}"><span
                                    class="icon-trash-o"></span> 删除</a>
                            <a class="button border-blue"
                               href="<%=basePath%>roleController/updateRoleUi.do?roleId=${role.roleId}"><span
                                    class="icon-database"></span> 修改</a>
                            <a class="button border-yellow"
                               href="<%=basePath%>roleController/roleMenuSetUi.do?roleId=${role.roleId}"><span
                                    class="icon-user"></span> 分配菜单</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="10">
                    <div class="pagelist"><a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
                            href="">3</a><a href="">下一页</a><a href="">尾页</a></div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>
