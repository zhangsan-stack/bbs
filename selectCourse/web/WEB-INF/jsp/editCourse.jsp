<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.select.entity.Course"%>
<html>
<head>
    <title>edit</title>
</head>
<body>
    this is edit.jsp
    <c:if test="${sessionScope!= null}"></c:if>
    <%
        Course c =null;
        if(session != null){
            c = (Course) session.getAttribute("course");
            session.setAttribute("id", c.getId());
        }
    %>

<div class="aa">
    <form action="/editCourse" method="post" enctype="multipart/form-data">
       <%-- <div>
            <label >课程图片</label>
            <input type="file"  name="file" id="file"  />
            <input type="text" name="imgurl"  id="imgurl" size="28"
                   onchange="document.getElementById('file').value=this.value"  placeholder="课程图片"/>
        </div>
--%>
        <div>
            <label for="name">课程名称</label>
            <input type="text" class="" id="name" name="name" placeholder="课程id" value="<%=c.getId()%>">
        </div>
        <div>
            <label for="time">开课学期</label>
            <input type="text" class="" id="time" name="time" placeholder="开课学期" value="<%=c.getTime()%>">
        </div>
        <div>
            <label for="credit">课程学分</label>
            <input type="text" class="" id="credit" name="credit" placeholder="课程学分" value="<%=c.getCredit()%>">
        </div>
        <div>
            <label for="belong">授课老师</label>
            <input type="text" class="" id="belong" name="belong" placeholder="授课老师" value="<%=c.getBelong()%>">
        </div>
        <div>
            <label for="place">开课地点</label>
            <input type="text" class="" id="place" name="place" placeholder="开课地点" value="<%=c.getPlace()%>">
        </div>
        <div>
            <label for="amount">课程容量</label>
            <input type="text" class="" id="amount" name="amount" placeholder="课程容量" value="<%=c.getAmount()%>">
        </div>
        <div>
            <label for="detail">课程描述</label>
            <input type="text" class="" id="detail" name="detail" placeholder="课程描述" value="<%=c.getDetail()%>">
        </div>

        提交： <input type="submit" value="提交">

    </form>

</div>






</body>
</html>
