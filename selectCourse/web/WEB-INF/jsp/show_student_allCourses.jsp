<%@ page import="com.select.entity.Study" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/28
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show_student_allCourses</title>
</head>
<body>
this is show_student_allCourses.jsp
<c:if test="${sessionScope.student !=null}">
    <p>欢迎学生：${student.getName()}</p>
    <a href="/student/student_logout">退出</a>
</c:if>


<%
        List<Study> studies =(List<Study>) session.getAttribute("studies");
%>

<table>
    <thead>
        <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>授课老师</th>
            <th>学分</th>
            <th>开课学期</th>
            <th>操作</th>
        </tr>
    </thead>
    <%
        for(Study s : studies){

    %>

    <tbody>
        <td><%=s.getC_id()%></td>
        <td>
            <%=s.getC_name()%>
        </td>

        <td><%=s.getC_belong()%></td>
        <td><%=s.getC_credit()%></td>
        <td><%=s.getC_time()%></td>

    </tbody>
    <%
        }
    %>

</table>




</body>
</html>
