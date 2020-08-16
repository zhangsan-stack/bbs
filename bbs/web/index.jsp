<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/8
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>bbs</title>


  </head>
  <body>
  $END$
  <p>bbs论坛，一个新的项目</p>
这就是一个欢迎界面<p></p>
 <a href="/index2_main">index2</a>



  <p>下面是帖子展示</p>
  <div >
      <form action="${pageContext.servletContext.contextPath}/idnex2" method="post" >
          <i></i>
          <input autocomplete="off" placeholder="搜索内容" type="text" value="${firsttitle}" name="firsttitle"/>
          <input type="submit" value="提交"/>
      </form>

      <%--问题列表不是空--%>
      <c:if test="${questionList !=null}">
          <ul>
              <c:forEach items="${questionList}" var="question">
                  <li>
                      <a hre="javascript:;">
                          <img src="">
                      </a>
                      <h2>
                          <a hre="javascript:;">${question.fristtitle}</a>
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


  <p>显示登陆成功人的登录名</p>
  ${session.user.username}
  <c:if test="${session.user != null}">
      <p>欢迎${session.user.username}</p>
      <a href="${pageContext.servletContext.contextPath}/user/logout">退出</a>
      <a href="${pageContext.servletContext.contextPath}/ques/form">去编辑问题界面</a>
  </c:if>
    <c:if test="${username != null}">
        <p>${username}</p>

    </c:if>


  </body>
</html>
