<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list2</title>


<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script  src="${APP_PATH}/static/js/jquery-1.8.1.min.js"></script>
<link href="${APP_PATH}/static/css/bootstrap.min.css" rel="stylesheet">
<script  src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body>

this is list2
<div class="container">
	<div class="row" >
		<div class="col-md-12">
			<h1>ssm-crud</h1>
		</div>
	
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover">
				<tr>
					<th>#</th>
					<th>empName</th>
					<th>email</th>
					<th>deptName</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${pageInfo.list}" var="emp">
					<tr>
						<th>${emp.empId}</th>
						<th>${emp.empName}</th>
						<th>${emp.gender == "m" ?"男":"女"}</th>
						<th>${emp.email}</th>
						<th>${emp.department.deptName}</th>
						<th>
							<button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
							<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button>
						</th>
					</tr>	
				</c:forEach>
		
			</table>
		</div>
	
	
	</div>
	
	<div class="row">
		<div class="col-md-6">
			当前是第 ${pageInfo.pageNum} 页，总共是 ${pageInfo.pages} 页, 总共有 ${pageInfo.total} 条信息
		
		</div>
		<div class="col-md-6">
			<nav aria-label="Page navigation">
				  <ul class="pagination">
				  		<li><a href="${APP_PATH}/emps2?pn=1">首页</a></li>
				  
				  		<c:if test="${ pageInfo.hasPreviousPage}">
				  			 <li>
					      		<a href="${APP_PATH}/emps2?pn=${pageInfo.pageNum-1}" aria-label="Previous">
					       		 	<span aria-hidden="true">&laquo;</span>
					     		</a>
					    </li>
				  		</c:if>
				  			
				  
					  
					  
					   
					    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
					    	<c:if test="${page_Num == pageInfo.pageNum }">
					    		 <li class="active"><a href="#">${page_Num }</a></li>
					    	
					    	</c:if>
					    	<c:if test="${page_Num != pageInfo.pageNum }">
					    		 <li><a href="${APP_PATH}/emps2/?pn=${page_Num }">${page_Num }</a></li>
					    	
					    	</c:if>
					    	
					    	
					    </c:forEach>
					    <c:if test="${pageInfo.hasNextPage}">					
							 <li>
							     <a href="${APP_PATH}/emps2?pn=${pageInfo.pageNum +1}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							 </li>
					    
					    </c:if>
					    	
					  
					     <li><a href="${APP_PATH}/emps2?pn=${pageInfo.pages}">末页</a></li>
				  </ul>
			</nav>
		</div>		
	</div>

</div>

</body>
</html>