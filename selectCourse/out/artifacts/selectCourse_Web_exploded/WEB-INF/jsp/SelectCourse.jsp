<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/25
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.select.entity.Course"%>
<%@ page import="java.util.List" %>
<%@ page import="com.select.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is SelectCourse.jsp
<c:if test="${sessionScope.student !=null}">
    <p>欢迎学生：${student.getName()}</p>
    <a href="/student/student_logout">退出</a>
</c:if>
<%
    Student student =(Student) session.getAttribute("student");
%>

<%
    List<Course> courses =(List<Course>) session.getAttribute("courses");
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
    <tr>
        <%
            for(Course c: courses ){
                int num = 1;
        %>
        <td><%=num++ %></td><br>
        <td><%=c.getId()%></td>
        <td><%=c.getName()%></td>
        <td><%=c.getTime()%></td>
        <td><%=c.getCredit()%></td>
        <td><%=c.getBelong()%></td>
        <td><%=c.getPlace()%></td>
        <td><%=c.getAmount()%></td>
        <td>

            <a href="/showDetail?id=<%=c.getId()%>">详情</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<br>
<a href="/study/showMyCourses?s_id=<%=student.getId()%>">显示我已近选过的课程</a>



</body>
</html>
