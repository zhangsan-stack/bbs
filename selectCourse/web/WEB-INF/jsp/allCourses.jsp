<%@ page import="com.select.entity.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<html>
<head>
    <title>allCourses</title>


</head>
<body>
this is allCourses.jsp
<%
    List<Course> course =(List<Course>)session.getAttribute("courses");
    String msg = (String) session.getAttribute("msg");
    int num = 1;

%>
 <form enctype="multipart/form-data">
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
            for(Course c : course){
        %>
        <tr>
            <td>
                <%=num++ %>
            </td>
            <td>
                <%=c.getId()%>
            </td>
            <td>
                <%=c.getName() %>
            </td>
            <td>
                <%=c.getTime() %>
            </td>
            <td>
                <%=c.getCredit() %>
            </td>
            <td>
                <%=c.getBelong() %>
            </td>
            <td>
                <%=c.getPlace() %>
            </td>
            <td>
                <%=c.getSelected() %>
            </td>
            <td>
                <%=c.getSelected() %>
            </td>
            <td>
                <a href="/editCourse?id=<%=c.getId()%>">改变</a>
                <a href="/deleteById?id=<%=c.getId()%>">删除</a>
            </td>

        <%
            }
        %>

    </tbody>

</table>


 </form>

</body>
</html>
