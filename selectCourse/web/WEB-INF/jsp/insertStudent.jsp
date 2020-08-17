<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertStudent</title>
</head>
<body>
this is insertStudent
<form action="/student/insertStudent">
    name:<input type="text" name="name" ><br>
    password:<input type="password" name="password"><br>
    sex:<input type="text" name="sex"><br>
    year:<input type="text" name="year"><br>
    major:<input type="text" name="major"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
