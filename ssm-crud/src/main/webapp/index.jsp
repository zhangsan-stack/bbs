<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>

<% 
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script  src="${APP_PATH}/static/js/jquery-1.8.1.min.js"></script>
<link href="${APP_PATH}/static/css/bootstrap.min.css" rel="stylesheet">
<script  src="${APP_PATH}/static/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 员工修改 -->
<div class="modal fade" id="empUpdateModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">员工修改</h4>
      </div>
   <div class="modal-body">
   	<form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">empName</label>
		    <div class="col-sm-10">
		      <p class="form-control-static" id="empName_update_static"></p>
				
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@qq.com">
		   	  <span class="help-block"></span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
		  		<input type="radio" name="gender" id="gender1_update_input" value="m" checked="checked"> 男
				</label>
			 <label class="radio-inline">
		  		<input type="radio" name="gender" id="gender2_update_input" value="f"> 女
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
        <button type="button" class="btn btn-primary" id="emp_update_btn">update</button>
      </div>
    </div>
  </div>
</div>











<!-- 员工添加 -->
<!-- Modal -->
<div class="modal fade" id="empAddModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
		       <span class="help-block"></span>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@qq.com">
		   	  <span class="help-block"></span>
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
		    	<select class="form-control" name="dId" id="dept_add_select">
				  
			    </select>
		    </div>
		  </div>
  
 	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn">Save changes</button>
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
				<button class="btn btn-danger" id="emp_delete_all_btn">批量删除</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="emps_table">
			<thead>
				<tr>
					<th>
						<input type="checkbox" id="check_all">
					
					</th>
				
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
//记录数据总条数
	var totalRecord;
	var currentNum;
	
	 $(function(){
		to_page(1);
	}); 
	
	//点击去哪一页按钮
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
			var checkBoxTd = $("<td><input type='checkbox' class='check_item'></td>")
			
			var empIdTd = $("<td></td>").append(item.empId);
			var empNameTd = $("<td></td>").append(item.empName);
			var genderTd =  $("<td></td>").append(item.gender== 'm'?"nan" : "nv");
			var emailTd = $("<td></td>").append(item.email);
			
			var deptName = $("<td></td>").append(item.department.deptName);
			
			var editBtn  = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
												 .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
												 .append("编辑");
			
			editBtn.attr("edit-id",item.empId);
			var delBtn   = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
												 .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
												 .append("删除");
			delBtn.attr("delete-id", item.empId);
			var btnTd = $("<td></td>").append(editBtn)
									  .append(" ")
									  .append(delBtn);
			$("<tr></tr>").append(checkBoxTd)
						  .append(empIdTd)
						  .append(empNameTd)
						  .append(genderTd)
						  .append(emailTd)
						  .append(deptName)
						  .append(btnTd)
						  .appendTo("#emps_table tbody");
		
		});
		
	}
	
	//，下部导航条解析
	function build_page_info_(result){
		
		$("#page_info_area").empty();
		
		$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+ "总共 "+ 
									result.extend.pageInfo.pages + " 页" + "总共" + 
									result.extend.pageInfo.total+ " 条记录");
	
			totalRecord = result.extend.pageInfo.total;
			currentNum  = result.extend.pageInfo.pageNum;
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
	
	
	//新增按钮被点击事件
	$("#emp_add_model2").click(function(){
		reset_from("#empAddModel form");
		alert("新增按钮被点击了");
		getDepts("#dept_add_select");
		//显示模态框
		  $("#empAddModel").modal({
			backdrop:"static"
		});
		  console.log("xin zeng an niu");
	});
	
	//访问后端，得到部门表信息
	function getDepts(ele){
		//清空下拉列表的值
		$(ele).empty();
		
		
		$.ajax({
			url:"${APP_PATH}/depts2",
			type:"GET",
			success:function(result){
				console.log(result);
				//$("#dept_add_select").append("")
				$.each(result.extend.depts2, function(){
					var optionEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
					optionEle.appendTo(ele);
				});
			
			}	
		});		
	}


	function validate_add_form(){
		//1拿到要校验的数据
		var empName =  $("#empName_add_input").val();
		alert(empName);
		var regName= /([0-9]{3})/  
		/*定义验证表达式*/
		if(regName.test(empName)){
			
			show_validate_msg("#empName_add_input","success", "");
					
		}else{		
			alert(regName.test(empName) + " : regName.test(empName)")
			show_validate_msg("#empName_add_input","error", "用户是3个数字或者3到4个中文，前端消息");
			return false;
		}	 
		
		//邮箱校验
		var email =  $("#email_add_input").val();
		alert(email);
		var regEmail = /([0-9]{3})/ ;
	
		if(regEmail.test(email)){
			show_validate_msg("#email_add_input","success", "");	
			alert("regEmail ： " + regEmail.test(email) );
		
		}else{	
			
			alert("regEmail的取反: " + !regEmail.test(email));
			show_validate_msg("#email_add_input","error", "邮箱格式不合法,前端消息");
			return false;	
		}
		return true;	
	}
	
	//显示校验结果
	function show_validate_msg(ele,status, msg){
		//清除当前元素校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		
		
		if("success" == status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
			
		}else if("error" == status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
	
	//给员工姓名输入框绑定一个change事件

	$("#empName_add_input").change(function(){
		var empName = this.value;
		$.ajax({
			url:"${APP_PATH}/checkuser",
			data:"empName="+empName,
			type:"POST",
			success:function(result){
				if(result.code == 100){
					show_validate_msg("#empName_add_input","success", "用户名可用,来自后端");
					$("#emp_save_btn").attr("ajax-va","success");
				
				}else{
					show_validate_msg("#empName_add_input","error", result.extend.va_msg);
					$("#emp_save_btn").attr("ajax-va","error");
				}
			}
		})
		
	})
	
	//清空表单样式以及内容
	function reset_from(ele){
		$(ele)[0].reset();
		//清空表单样式
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	}

	//点击新增弹出模态框
	$("#emp_save_btn").click(function(){
		//清除模态框之前的数据,以及表单的样式成充值	
		
		
		//模态框中填写的表单数据提交给服务器保存
		 
		if(!validate_add_form()){
			return false;
		}
		//判断之前的ajax用户名校验是否成功
		if($(this).attr("ajax-va") == "error"){
			return false;
		}
		
		
		$.ajax({
			url:"${APP_PATH}/emp2",
			type:"POST",
			data:$("#empAddModel form").serialize(),
			success:function(result){
				//关闭模态框
				if(result.code == 100){
					$("#empAddModel").modal("hide");
					//来到最后一页
					//发送ajax请求，来到最后一页
					to_page(totalRecord);
				}else{
					//显示失败信息
					console.log(result);	
					
					if(undefined != result.extend.errorField.email){
						show_validate_msg("#email_add_input", "error", result.extend.errorField.email)
					}
					if(undefined != result.extend.errorField.empName){
						show_validate_msg("#empName_add_input", "error", result.extend.errorField.empName)
						
					}
				}
									
			}
		}) 		
	})
	
	
	
	
	//给编辑按绑定点击事件
	$(document).on("click", ".edit_btn",function(){
		alert("update");
		//也要查询出部门信息，显示部门列表并且查出员工id，名字等
		//显示模态框
		getDepts("#empUpdateModel select");
		
		//查询员工信息
		
		//得到员工id
		getEmp($(this).attr("edit-id"));
		
		//把员工id传递个更新按钮
		$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
		
		$("#empUpdateModel").modal({
			backdrop:"static"
		});
			
		
		
	})
	
	function getEmp(id){
		$.ajax({
			url:"${APP_PATH}/emp/"+id,
			type:"GET",
			success: function(result){
				console.log(result);
				var empData = result.extend.emp;
				$("#empName_update_static").text(empData.empName);
				$("#email_update_input").val(empData.email);
				$("#empUpdateModel input[name=gender]").val([empData.gender]);
				$("#empUpdateModel select").val([empData.dId]);
							
			}
			
		})
	}
	
	$("#emp_update_btn").click(function(){
		//验证邮箱验证是否和法
		//邮箱校验
		var email =  $("#email_update_input").val();
		alert(email);
		var regEmail = /([0-9]{3})/ ;
	
		if(regEmail.test(email)){
			show_validate_msg("#email_update_input","success", "");	
			alert("regEmail ： " + regEmail.test(email) );
		
		}else{	
			alert("regEmail的取反: " + !regEmail.test(email));
			show_validate_msg("#email_update_input","error", "邮箱格式不合法,前端消息");
			return false;	
		}
		//发送ajax请求，更新保存员工信息
		
		$.ajax({
			url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
			type:"PUT",
			data:$("#empUpdateModel form").serialize()+"&_method=PUT",
			success:function(result){
				alert(result.msg);
				
				//1关闭模态框
				 $("#empUpdateModel").modal("hide");
				//2回到原来页面
				to_page(currentNum);	
			}
			
		})
			
	})
	//点击删除，单个删除
	
	 $(document).on("click", ".delete_btn",function(){
		 //单个删除
		  var empName =  $(this).parents("tr").find("td:eq(2)").text();
		  var empId   =  $(this).attr("delete-id");
		 if(confirm("确认删除 " + empName+ " 么")){
			 //确认的话，发送ajax
			 $.ajax({
				 url:"${APP_PATH}/emp2/"+empId,
				 type:"DELETE",
				 success:function(result){
					 alert(result.msg);
					 //回到本页
					 to_page(currentNum);
				 }		 
			 })
		 }	 
	 })
	
	//完成全选
	$("#check_all").click(function(){
		
		//attr获取会得到unfined
	 	$(this).prop("checked");
		$(".check_item").prop("checked", $(this).prop("checked"));
		
		
	})
	//为每一个check_iterm绑定单机事件
	$(document).on("click", ".check_item", function(){
		//判断当前选中的元素是不是五个
	 	var flag =  $(".check_item:checked").length == $(".check_item").length;
		
		$("#check_all").prop("checked", flag);
		
	})
	
	
	//点击全部删除，就批量删除
	$("#emp_delete_all_btn").click(function(){
	//	$(".check_item:checked");
		var del_idstr = "";
		var empNames ="";
		$.each($(".check_item:checked"), function(){
			empNames +=	$(this).parents("tr").find("td:eq(2)").text()+ ",";
			del_idstr +=$(this).parents("tr").find("td:eq(1)").text()+ "-"
			//组装一下员工id字符窜
		
		})
		
		//取出empNames多余的逗号
	    empNames  = empNames.substring(0,empNames.length-1);
		//取出多余的段很闲
		del_idstr = del_idstr.substring(0,del_idstr.length-1);
		if(confirm("确认删除 " + empNames + "吗？")){
			$.ajax({
				url:"${APP_PATH}/emp2/"+del_idstr,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					
					to_page(currentNum);
				}
				
			})
			
			
		}
	})
	
	
	
	
	
</script>
</body>
</html>