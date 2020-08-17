<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list3</title>

<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script  src="${APP_PATH}/static/js/jquery-1.8.1.min.js"></script>
<link href="${APP_PATH}/static/css/bootstrap.min.css" rel="stylesheet">
<script  src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 员工添加 -->
<!-- Modal -->
<div class="modal fade" id="empAddModel2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
      </div>
   <div class="modal-body">
      
 <form class="form-horizontal">
  <div class="form-group">
    <label class="col-sm-2 control-label">empName</label>
    <div class="col-sm-10">
      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">email</label>
    <div class="col-sm-10">
      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@qq.com">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">gender</label>
    <div class="col-sm-10">
      <label class="radio-inline">
  		<input type="radio" name="gender" id="gender1_add_input" value="m" checked="checked"> 男
		</label>
	 <label class="radio-inline">
  		<input type="radio" name="gender" id="gender2_add_input" value="f"> 女
	</label>  
    </div>
  </div>
  
  
  <div class="form-group">
    <label class="col-sm-2 control-label">deptName</label>
    <div class="col-sm-4">
    <!-- 部门要查出来，提交dId -->
    	<select class="form-control" name="dId">
		  
	    </select>
    </div>
  </div>
  
     </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


this is list2
<div class="container">
	<div class="row" >
		<div class="col-md-12">
			<h1>ssm-crud</h1>
		</div>
	
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_model2">新增</button>
				<button class="btn btn-danger">删除</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="emps_table">
			<thead>
				<tr>
					<th>#</th>
					<th>empName</th>
					<th>gender</th>
					<th>email</th>
					<th>deptName</th>
					<th>操作</th>
				</tr>	
			</thead>
			<tbody>
						
			</tbody>
					
			</table>
		</div>
	
	
	</div>
	
	<div class="row">
		<!-- 分页信息 -->
		<div class="col-md-6" id="page_info_area">
			
		</div>
		<!-- 分页导航条 -->
		<div class="col-md-6" id="page_nav_area">
			
		</div>		
	</div>

</div>
<script type="text/javascript">
	
	 $(function(){
		to_page(1);
	}); 
	
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/emps2",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result)		
					build_emps_table(result);	
					build_page_info_(result);
					build_page_nav(result);				
				}
				
			});
		}
	
	function build_emps_table(result){
		//如果有数据的话，就清空，不然会叠加显示
		$("#emps_table tbody").empty();
		
		var emps = result.extend.pageInfo.list;
		$.each(emps, function(index, item){
			var empIdTd = $("<td></td>").append(item.empId);
			var empNameTd = $("<td></td>").append(item.empName);
			var genderTd =  $("<td></td>").append(item.gender== 'm'?"nan" : "nv");
			var emailTd = $("<td></td>").append(item.email);
			
			var deptName = $("<td></td>").append(item.department.deptName);
			
			var editBtn  = $("<button></button>").addClass("btn btn-primary btn-sm")
												 .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
												 .append("编辑");
			var delBtn   = $("<button></button>").addClass("btn btn-danger btn-sm")
												 .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
												 .append("删除");
			
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			$("<tr></tr>").append(empIdTd).append(empNameTd)
			.append(genderTd).append(emailTd).append(deptName).append(btnTd)
			.appendTo("#emps_table tbody");
		
		});
		
	}
	//解析
	function build_page_info_(result){
		
		$("#page_info_area").empty();
		
		$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+ "总共 "+ 
									result.extend.pageInfo.pages + " 页" + "总共" + 
									result.extend.pageInfo.total+ " 条记录");
	}
	
	//导航条制作
	function build_page_nav(result){
		
		$("#page_nav_area").empty();
		
		var ul= $("<ul></ul>").addClass("pagination")
		
		var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
		var prePage   = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if(result.extend.pageInfo.hasPreviousPage == false){
			firstPage.addClass("disabled");
			prePage.addClass("disabled");
		}
		
		//首页和前一页点击按钮事件
		firstPage.click(function(){
			to_page(1);
		})
		prePage.click(function(){
			to_page(result.extend.pageInfo.pageNum -1);
		})
			
		var nextPage  = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPage = $("<li></li>").append($("<a></a>").append("尾页").attr("href", "#"));
		if(result.extend.pageInfo.hasNextPage == false){
			nextPage.addClass("disabled");
			lastPage.addClass("disabled");
		}
		//下一页和末页
		nextPage.click(function(){
			to_page(result.extend.pageInfo.pageNum + 1);
			
		});
		
		lastPage.click(function(){
			to_page(result.extend.pageInfo.pages);
		});
		
		
		ul.append(firstPage).append(prePage).append()
		
		//页码数
		$.each(result.extend.pageInfo.navigatepageNums,function(index, item){
			var numLi = $("<li></li>").append($("<a></a>").append(item));
				
			if(result.extend.pageInfo.pageNum == item){
				numLi.addClass("active");
			}
			numLi.click(function(){
				to_page(item);
			})
				
			ul.append(numLi);
		});
		//添加下一页和末页的提示
		ul.append(nextPage).append(lastPage);
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
		
	}
	
	
	//天厨
	$("#emp_add_model2").click(function(){
		alert("新增按钮被点击了");
		
		  $("#empAddModel2").modal({
			backdrop:"static"
		});
		  console.log("xin zeng an niu");
	});
	
	function getDepts( ){
		$.ajax({
			url:"${APP_PATH}/depts2",
			type:"GET",
			success:function(result){
				console.log(result);
			}
			
			
		})
		
	}
	

	
</script>
</body>
</html>