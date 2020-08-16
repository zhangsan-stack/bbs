<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2020/8/8
Time: 8:35
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.servletContext.contextPath}/js/jquery-3.3.1.js"></script>




</head>
<body>
this is  detail.html
<%--问题列表不是空--%>
<c:if test="${firsttitle !=null}">
    <ul>
        <c:forEach items="${firsttitle}" var="title">
            <li>
                <a>
                    <img src="">
                </a>
                <h2>
                    <p>帖子标题：${firsttitle}</>
                  <%--  把每一个帖子都做成一个表格，做成proble对象--%>

                    <form action="/answer_question">
                        回复内容content: <input type="text" name="content">
                        <input type="text" name="questionid"  value="${questionid}" hidden="hidden">

                        <input type="submit" value="回复">
                    </form>
                    <p>下面是所有回复的帖子点击按钮查看</p>
                    <p>是通过问题的id，来查询数据库，返回给前端页面</p>
                    <p>这个表单提交问题id，然后获取mode，传给前端，刷新显示</p>

                    <input id="get_answer"  value="${questionid}"></input>

                    <button onclick="get_answer()" >点击</button>
                    <from>

                    </from>

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

<c:if test="${firsttitle == null}">
    <div>我靠，没拿到数据，弄错了</div>

</c:if>

<table id="div_0">

</table>

<script type="text/javascript">
    function  get_answer() {
        alert("ok");
        var questionid = $("#get_answer").val();
        alert(questionid);
        $.ajax({
            url:"${pageContext.servletContext.contextPath}" + "/getTotalAnswerById",
            data: {"questionid" :questionid},
            async:true,
            type: "post",
            success: function (data) {
                console.log("ok");
                console.log(data);
                var div_0 = $("#div_0");
                var tablehtml = "<tr><th>回复内容</th></tr>";
                for(var i = 0 ; i<data.length; i++){
                    tablehtml +="<tr><td>"+data[i].content+"</td></tr>"
                }
                div_0.html(tablehtml);

            }
        })
    }

</script>


<%--var lis = "<li></li>";
$.each(JSON.parse(ListUserJson),function(index, xx){
lis +="<li>[index].content</li>"
$("#div_0").append(lis);
})--%>


</body>
</html>