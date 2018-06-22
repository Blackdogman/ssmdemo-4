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
    <script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
    <script type="text/javascript" src="<%=basePath%>view/frame/menupage/listPage.js"></script>
</head>
<body onload="load();">
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
        <div class="padding border-bottom">
            <%--<ul class="search">--%>
                <%--<li>--%>
                    <%--<a href="<%=basePath%>menuController/addMenuUi.do" class="button border-blue" id=""><span--%>
                            <%--class="icon-plus"></span> 添加--%>
                    <%--</a>--%>
                    <%--<button type="button" class="button border-green" id="checkall"><span class="icon-check"></span> 全选--%>
                    <%--</button>--%>
                <%--</li>--%>
            <%--</ul>--%>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>邮件id</th>
                <th>收件人</th>
                <th>邮件主题</th>
                <th>发送时间</th>
                <%--<th>邮件内容</th>--%>
            </tr>
            <c:forEach var="mail" items="${pageResult.dataList}">
                <tr>
                    <td><input type="checkbox" name="id[]" value="1"/>
                            ${mail.mailId}
                    </td>
                    <td>${mail.toUserId}</td>
                    <td>${mail.mailSubject}</td>
                    <td><fmt:formatDate value="${mail.createTime}" type="both"/>
                    </td><%--<td>${mail.mailContent}</td>--%>
                    <%--<td>--%>
                        <%--<div class="button-group">--%>
                            <%--<a class="button border-red"--%>
                               <%--href="<%=basePath%>menuController/deleteMenu.do?menuId=${menu.menuId}"><span--%>
                                    <%--class="icon-trash-o"></span> 删除</a>--%>
                            <%--<a class="button border-blue"--%>
                               <%--href="<%=basePath%>menuController/updateMenuUi.do?menuId=${menu.menuId}"><span--%>
                                    <%--class="icon-database"></span> 修改</a>--%>
                        <%--</div>--%>
                    <%--</td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<div align="center" id="jpager"></div>
<script type="text/javascript">
    function load() {
        arrayPage(${pageResult.pages},${pageResult.total});
    }


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
