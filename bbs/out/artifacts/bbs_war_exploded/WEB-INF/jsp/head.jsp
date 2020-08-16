<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/9
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>head</title>
</head>
<body>

<c:if test="${session.user ==null}">
    <a href="${pageContext.servletContext.contextPath}/user/loginPage" target="_blank">登录</a>
    <a href="${pageContext.servletContext.contextPath}/user/registerPage" target="_blank">注册</a>

</c:if>
<c:if test="${session.user != null}">
    <a ${session.user}></a>
    <a href="${pageContext.servletContext.contextPath}/user/logout">退出</a>

</c:if>

</body>
</html>
