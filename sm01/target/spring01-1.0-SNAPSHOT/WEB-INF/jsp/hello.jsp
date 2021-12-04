<%--
  Created by IntelliJ IDEA.
  User: wangbaoqing
  Date: 2021/11/26
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>hello,${sessionScope.user.username}</h1>
<div>
    <p>${CRUDmsg}</p>
    <a href="${pageContext.request.contextPath}/user/welcome">返回欢迎页</a>
</div>
<form action="${pageContext.request.contextPath}/param/upload" enctype="multipart/form-data" method="post"/>
上传头像:<input type="file" name="image"><br>
<input type="submit" value="上传">
</body>
</html>
