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
    <title>注册界面</title>

    <script src="${pageContext.servletContext.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
this is register.page
${pageContext.servletContext.contextPath}
<p></p>
<form   method="post"  id="registerForm" action="/user/register">
    登录名:<input type="text" name="loginname" id="loginname" placeholder="登录名"></inupt><p></p>
    密码：<input type="text" name="password" id="password" placeholder="密码"></inupt><p></p>
    密码：<input type="text" name="repass" id="repass" placeholder="密码"></inupt><p></p>
        <input type="submit" value="提交"/>
    <%--<button onclick="register()" >注册</button>--%>

</form>

<script type="text/javascript">

    //登录按钮的点击事件
    function register(){
        alert("register");
        //获取表单中登录名和密码
        var loginname = $("#loginname").val();
        var password  = $("#password").val();
        var repass    = $("#repass").val();
        //以上是jquery提供的原生方法
        if(loginname == ""){
            alert("请填写登录名");
            return false;
        }
        if(password ==""){
            alert("请填写密码");
            return false;
        }
        if(password != repass){
            alert("两次的密码不一致!");
            return false;
        }

        alert("前端检查已通过");
        //下面是其他方法,springmvc可以把表单数据序列化成一个对象，
        // 可以获取所有输入框的值，以键值对的方式，表单输入框的id必须和后台实体类的属性名一致,不一致就报错
        //var formData = $("#registerForm").serialize();

        //ajax发送给后台，进行验证
        $.ajax({
            url: "${pageContext.servletContext.contextPath}"+"/user/register",
            data: {"loginname": loginname, "password": password},
           // data: formData,
            type: "post",
            success: function (msg) {
                alert(msg);
                if(msg == "101"){
                    alsert(msg)
                    //登录成功，跳转到首页
                    window.location.href="${pageContext.servletContext.contextPath}"+"/deal_ok/index2";
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
