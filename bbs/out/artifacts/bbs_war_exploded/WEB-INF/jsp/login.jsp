<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/8
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.servletContext.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
this is login.page ;
${pageContext.servletContext.contextPath}
<p>这个是登录界面，使用shiro矿建，同步登录</p>

<form action="${pageContext.servletContext.contextPath}/user/login" id="loginForm" method="post">
    登录名:<input type="text" name="username" id="loginname" placeholder="登录名"></inupt><p></p>
    密码：<input type="text" name="password" id="password" placeholder="密码"></inupt><p></p>
       <%-- <button onclick="login(); return false" >登录</button>--%>
    <input type="submit" name="提交" value="提交">
</form>

<script type="text/javascript">
    //登录按钮的点击事件
    function login(){
        alert("66")
        //获取表单中登录名和密码
        var loginname =$("#loginname").val();
        var password = $("#password").val();
        //以上是jquery提供的原生方法

        //下面是其他方法,springmvc可以把表单数据序列化成一个对象，
        // 可以获取所有输入框的值，以键值对的方式，表单输入框的id必须和后台实体类的属性名一致,不一致就报错
        //var formData = $("#loginForm").serialize();
        alert(loginname);
        alert(password);
        alert("777");
        //ajax发送给后台，进行验证
        $.ajax({
            url: "${pageContext.servletContext.contextPath}"+"/user/login",
            data: {"loginname": loginname, "password": password},
          //  data: formData,
            type: "post",
            success: function (msg) {
                    if(msg != ""){
                        alert("验正成功");
                        //登录成功，跳转到首页index
                    }else{
                        //登录失败
                        alert("账号或者密码不正确");
                        return;
                    }
                }
        })
    }
</script>

</body>
</html>
