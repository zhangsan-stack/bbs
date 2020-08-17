<%@ page import="com.select.entity.Course"%>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script scr="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

</head>
<body>

this is index.jsp
<br>
<p>这个测试表格</p>
<form action="/insert">
    用户名: <input type="text" name="username"  ><br>
    密码:<input type="text" name="password" ><br>
    <input type="submit">
</form>
<p>下面是正常业务页面</p>

<p>去往管理员登录页面</p>
<a href="/gotoLogin">gotoLogin：管理员登录</a>
<p>下面是登陆成功后显示的界面</p>
<a href="/student/goto_student_login">去往学生登录界面</a>

<a href="/gotoSelectCourse">去往学生选课界面</a>




</body>
</html>
