<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/10
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>questionForm</title>
</head>
<body>

this is questionForm.page

<form action="/ques/save">
    标题：<input  name="title" id="title"/><p></p>
    描述：<input  name="description" id="description"/><p></p>
    金币：<input  name="coin" id="coin"/><p></p>
    是否置顶：<input  name="isup" id="isup"/><p></p>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
