<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/17
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>admin</title>
</head>
<body>
this is admin.jsp
<c:if test="${sessionScope !=null}">
    <p>热烈欢迎id号为：${sessionScope.admin.id}的管理员</p>
</c:if>
<a href="goto_addCourse">去往增加课界面</a>

<a href="/courseManager">显示所有已增加选课</a><br>

<br></b><a href="/student/goto_insertStudent">去往增加学生界面</a>
<a href="/allStudents">去往显示所有学生的界面</a>


</body>
</html>
