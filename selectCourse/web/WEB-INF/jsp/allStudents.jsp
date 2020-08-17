<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/23
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.select.entity.Student"%>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allStudents</title>
</head>
<body>
this is allStudents.jsp

<%
    List<Student> students =(List<Student>)session.getAttribute("students");
    int num = 1;
%>
<table>
        <thead>
        <tr>编号</tr>
        <tr>课程编号</tr>
        <tr>课程名</tr>
        <tr>开课学期</tr>
        <tr>课程积分</tr>
        <tr>授课老师</tr>
        <tr>开课地点</tr>
        <tr>已选人数/课程容量</tr>
        <tr>操作</tr>
        </thead>
    <tbody>
    <%
        for(Student s : students){
    %>
    <tr>
        <td>
            <%=num++ %>
        </td>

        <td>
            <%=s.getId()%>
        </td>
        <td>
            <%=s.getName() %>
        </td>
        <td>
            <%=s.getSex() %>
        </td>
        <td>
            <%=s.getYear() %>
        </td>
        <td>
            <%=s.getMajor() %>
        </td>
        <td>
            <a href="/student/editStudent?id=<%=s.getId()%>">改变</a>
            <a href="/student/deleteById?id=<%=s.getId()%>">删除</a>
        </td>
    </tr>
            <%
            }
        %>

    </tbody>
</table>

</body>
</html>
