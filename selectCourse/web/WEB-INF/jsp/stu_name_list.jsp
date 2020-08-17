<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/27
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.select.entity.Study"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>stu_name_list</title>
</head>
<body>
    this is stu_name_list.jsp
<%
    if(session.getAttribute("studies") != null){
    	List<Study> studies =(List<Study>) session.getAttribute("studies");

%>
<table>
    <thead>
        <tr>
            选择该课程学生名单
        </tr>
    </thead>
    <tbody>
    <%
        for(Study s : studies){

    %>
        <tr>
            <td><%= s.getS_name()%></td>
        </tr>

    </tbody>

    <%
         }
    }
    %>


</table>


<a>返回课程列表</a>


</body>
</html>
