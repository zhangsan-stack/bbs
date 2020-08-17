<%@page import="com.select.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editStudent</title>

    <script type="text/javascript">
        function aa(){
            alert("aa");
        }

    </script>


</head>
<body>

this is editStudent.jsp
    <%
        Student s =null;
        if(session != null){
            s = (Student) session.getAttribute("student");
            session.setAttribute("id", s.getId());
        }
    %>

    <form action="/student/updateStudent" method="post">
        <div>
            <label></label>
            <input type="text" id="id" name="id" placeholder="id" value="<%=s.getId()%>"  readonly>
        </div>
        <div>
            <input type="text" id="password" name="password" value="<%=s.getPassword()%>" required>

        </div>
        <div>
            <label></label>
            <input type="text" id="name" name="name" placeholder="name" value="<%=s.getName() %>" required>
        </div>
        <div>
            <label></label>
            <input type="text" id="sex" name="sex" placeholder="sex" value="<%=s.getSex() %>" required>
        </div>
        <div>
            <label></label>
            <input type="text" id="major" name="major" placeholder="专业" value="<%=s.getMajor() %>" required>
        </div>
        <div>
            <label></label>
            <input type="text" id="year" name="year" placeholder="year" value="<%=s.getYear() %>" required>
        </div>
      <input type="submit" value="提交" onclick="aa()">

    </form>



</body>
</html>
