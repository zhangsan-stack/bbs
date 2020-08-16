<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/8
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>index2</title>
    <link rel="${pageContext.servletContext.contextPath}/assets/layui/css/layui.css">
    <link rel="${pageContext.servletContext.contextPath}/assets/layui/css/global.css">
    <script rel="${pageContext.servletContext.contextPath}/assets/layui/layui.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/jquery-3.3.1.js"></script>

    <style type="text/css">
        a{
            height:10px;
            width: 20px;"
        }

    </style>

</head>
<body>
this is index2,and this is the main page<p></p>
pageContext.servletContext.contextPath<p></p>

<p>这个地方用shiro框架重构，所以登录  地址写成shiro的地址</p>
<c:if test="${sessionScope.user == null}">
<a href="${pageContext.servletContext.contextPath}/user/login" target="_blank">登录</a>
<a href="${pageContext.servletContext.contextPath}/user/registerPage" target="_blank">注册</a>
</c:if>
<br>
<p>显示登陆成功人的登录名</p>

<c:if test="${sessionScope != null}">
    <p>欢迎${sessionScope.user.username}</p>
    <a href="${pageContext.servletContext.contextPath}/user/logout">退出</a>
    <a href="${pageContext.servletContext.contextPath}/ques/form">去编辑问题界面</a>
</c:if>

<p>下面是删除功能，根据id删除，测试专用</p>

<form  method="post"  id="loginForm">
    用户名:<input type="text" name="deleteById" id="deleteById" placeholder="id"></inupt><p></p>
    <button onclick="bb()">删除</button>
    <button onclick="aa()">aa</button>
</form>

<p>下面是提交问题的表单</p>
<form action="/ques/save">
    标题<input type="text" name="firsttitle" id="firsttitle"/><p></p>
    描述：<input  name="description" id="description"/><p></p>
    金币：<input  name="coin" id="coin"/><p></p>
    是否置顶：<input  name="isup" id="isup"/><p></p>
    <input type="submit" value="提交"/>
</form>

<br>
<p>根据porblem表的id删除数据</p>
<form  method="post"  id="loginForm">
    用户名:<input type="text" name="deleteById" id="deleteById_problem" placeholder="id"></inupt><p></p>
    <button onclick="cc()">cc</button>
</form>

<p>下面是添加likes表的表单，测试</p>
<form action="likes/insert">
    id: <input type="text" name="id" id="ids"  /><br>
    answerid:<input  type="text" name="answerid" id="answerid"/><br>
    userid:<input type="text" name="userid" id="userid"/><br>
  <%--  <input type="submit" value="提交"/>--%>
    <button value="提交" onclick="dd">提交</button>
</form>

<br><p>下面是添加回复的表单</p>
  <%--  <form action="/answer_question">
       content: <input type="text" name="content" id="content" /><p></p>
             <input type="submit" value="提交" />
    </form>--%>
    <br>

<p>下面是帖子展示</p>
<br>

<div >
    <form action="${pageContext.servletContext.contextPath}/index2" method="post" >
        <i></i>
        <input autocomplete="off" placeholder="搜索内容" type="text" value="${firsttitle}" name="firsttitle"/>
        <input type="submit" value="提交"/>
    </form>

    <%--问题列表不是空--%>
    <c:if test="${questionList !=null}">
        <ul>
            <c:forEach items="${questionList}" var="question">
                <li>
                    <a>
                        <img src="">
                    </a>
                    <h2>
                        <p>${question.firsttitle}</p>
                       <%--把每一个帖子都做成一个表格，做成proble对象--%>

                        <form action="${pageContext.servletContext.contextPath}/ques/detail">
                            <input type="text" name="firsttitle" value="${question.firsttitle}" readonly="true" >
                            <input type="text" name="questionid" value="${question.id}" hidden="hidden"/>
                            <input type="submit" value="回复">

                        </form>


                        <span>置顶</span>
                    </h2>
                    <p>
                        <span><a>贤心</a></span>
                        <span>刚刚</span>
                        <span>
                            <i title="回答">&#xe60c;</i>317
                        </span>
                    </p>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${questionList == null}">
        <div>并无相关数据</div>

    </c:if>



   <%-- 上面是问题列目标为空的--%>

</div>
    <script type="text/javascript">
    function dd(){
        var id = $("#ids").val();
        var answerid = $("#answerid").val();
        var userid = $("#userid").val();
        alert(id, answerid, user, "ok");
        $.ajax({
            url:"${pageContext.servletContext.contextPath}"+ "/likes/insert",
            data: {"answerid":answer_id,"userid": userid },
            type:"post",
            success:function(msg){
                if(msg == "101"){
                    alert(msg);
                }
            }
        })
    }
</script>


<script type="text/javascript">

    function save(){
        console.log("ok_1");
        var firstitle = $("#firstitle").val();
        console.log(title);
        var description = $("#description").val();
        console.log(description);
        var coin = $("#coin").val();
        console.log(coin);
        var isup = $("#isup").val();
        console.log(isup);
        console.log("ok_2");

        $.ajax({
            url: "${pageContext.servletContext.contextPath}" +"/ques/save",
            data:{"firsttitle": firstitle ,"description": description, "coin": coin, "isup": isup },
            type: "post",
            success: function(){
                console.log("ok_3");
            }
         })
    }
</script>


<script type="text/javascript">
    function cc(){
        alert("cc");
        var ids = $("#deleteById_problem").val();
        alert("cc");
        $.ajax({
            url:"${pageContext.servletContext.contextPath}" +"ques/delete",
            data:{"id": ids},
            type:"post",
            success: function (msg) {
                alert(msg);
            }
        })
    }

</script>

<script type="text/javascript">
    function bb(){
        alert("cc");
        var ids = $("#deleteById").val();
        alert("cc");
        $.ajax({
            url:"${pageContext.servletContext.contextPath}" +"user/deleteById",
            data:{"id": ids},
            type:"post",
            success: function (msg) {
                alert(msg);
            }
        })
    }

</script>



</body>
</html>
