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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>userController/addUser.do">
            <div class="form-group">
                <div class="label">
                    <label>用户姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="userName" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>登陆名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="loginName" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>登陆密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="password" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>邮箱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="email" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="sex" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>生日：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="birthday" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>籍贯：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="nativePlace" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>毕业院校：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="recordSchool" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>

    </div>
</div>

</body>
</html>