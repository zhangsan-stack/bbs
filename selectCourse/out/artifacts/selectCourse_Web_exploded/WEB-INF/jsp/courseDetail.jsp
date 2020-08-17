<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/26
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.select.entity.Course"%>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.context.request.SessionScope" %>

<html>
<head>
    <title>courseDetail</title>
</head>
<body>
this is courseDetail
this is SelectCourse.jsp
<c:if test="${sessionScope.student !=null}">
    <p>欢迎学生：${student.getName()}</p>
    <a href="/student/student_logout">退出</a>
</c:if>

<%
    Course course = (Course) session.getAttribute("course");
    String  msg =null;
    if(session !=null ){
        msg = (String) session.getAttribute("msg");
    }

%>
<%
    if(msg !=null){
        if(msg.equals("选课成功")){
%>
    <div>
        <Strong><%=msg%></Strong>

    </div>

<%
    }else{
%>
    <div>
        <strong><%=msg%></strong>
    </div>
<%
        }
    session.setAttribute("msg", null);
    }
%>


<br>
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
        <td><%=course.getId()%></td>
        <td><%=course.getName()%></td>
        <td><%=course.getTime()%></td>
        <td><%=course.getCredit()%></td>
        <td><%=course.getBelong()%></td>
        <td><%=course.getPlace()%></td>
        <td><%=course.getSelected()%></td>
        <td><%=course.getAmount()%></td>
        <td><%=course.getDetail()%></td>
    </tr>

    </tbody>
</table>
<br>
<a href="/select/selectCourseFinally?id=<%=course.getId()%>">选择</a>
<a href="/student/show_student_who_selected_this_course?c_id=<%=course.getId()%>">查看选该门课程的学生名单</a>

</body>
</html>
