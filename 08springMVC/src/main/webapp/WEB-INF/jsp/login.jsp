<%--
  Created by IntelliJ IDEA.
  User: zong
  Date: 2022/4/29
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
web-INF：登录页面
<br>
<form action="${pageContext.request.contextPath}/login">
    姓名：<input name="name">
    密码：<input type="password" name="pwd">
    <input type="submit" value="登录">
</form>
<div>${msg}</div>
</body>
</html>
