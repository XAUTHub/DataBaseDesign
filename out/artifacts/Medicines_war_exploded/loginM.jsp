<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/12
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录到药品进销存管理系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/loginServlet">

        <h2 class="form-signin-heading">请登录</h2>

        <label class="sr-only">用户名</label>
        <input type="text" id="username" class="form-control" name="username"placeholder="username">
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" class="form-control" name="password" placeholder="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <button class="btn btn-lg btn-primary btn-success btn-block" type="button" onclick="javascript:window.location.href='register.jsp';">注册</button>
    </form>
</div>
</body>
</html>
