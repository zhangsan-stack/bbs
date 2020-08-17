<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<html>
<head>
    <title>addCourse</title>

    <style>
        body{
            padding-top:100px;
            padding-bottom: 40px;
            background-color: #eee;
        }
        form{
            max-width:330px;
            padding:15px;
            margin: 0 auto;
        }
    </style>

</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/insertCourse" enctype="multipart/form-data" method="post">
        <%--<div>
            <label >课程图片</label>
            <input type="file"  name="file" id="file" />
            <input type="text" name="imgurl"  id="imgurl" size="28"
                   onchange="document.getElementById('file').value=this.value"  placeholder="课程图片"/>
        </div>--%>

        <div>
            <label for="name">课程名称</label>
            <input type="text" class="" id="name" name="name" placeholder="课程id">
        </div>
        <div>
            <label for="time">开课学期</label>
            <input type="text" class="" id="time" name="time" placeholder="开课学期">
        </div>
        <div>
            <label for="credit">课程学分</label>
            <input type="text" class="" id="credit" name="credit" placeholder="课程学分">
        </div>
        <div>
            <label for="belong">授课老师</label>
            <input type="text" class="" id="belong" name="belong" placeholder="授课老师">
        </div>
        <div>
            <label for="place">开课地点</label>
            <input type="text" class="" id="place" name="place" placeholder="开课地点">
        </div>
        <div>
            <label for="amount">课程容量</label>
            <input type="text" class="" id="amount" name="amount" placeholder="课程容量">
        </div>
        <div>
            <label for="detail">课程描述</label>
            <input type="text" class="" id="detail" name="detail" placeholder="课程容量">
        </div>

            提交： <input type="submit" value="提交">

    </form>


</div>























</body>
</html>
