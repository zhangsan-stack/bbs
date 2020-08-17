package com.wdjr.crud.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.bean.Msg;
import com.wdjr.crud.bean.Msg2;
import com.wdjr.crud.service.EmployeeService;
import com.wdjr.crud.service.EmployeeService2;

/*
 * 处理CRUD请求
 * */

@Controller
public class EmployeeController2 {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Autowired
	EmployeeService2 employeeService2;
	
	//删除对象，单个和批量二合一
	@ResponseBody
	@RequestMapping(value="/emp2/{empId}",method= RequestMethod.DELETE)
	public Msg2 deleteEmpHId(@PathVariable("empId")String empIds) {
		//批量删除
		
		if(empIds.contains("-")) {
			
			List<Integer> del_ids = new ArrayList<>();
 			
			String [] str_ids = empIds.split("-");
		 	//组装id集合
			for(String string  : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			
			
			employeeService.deleteBatch(del_ids);
		}else {
			Integer empId =  Integer.parseInt(empIds);
			employeeService2.deleteEmp(empId);
		}
	
		System.out.println("delete emp");
		return Msg2.success();
	}
	
	
	
	
	
	
	
	
	//更新员工
	@ResponseBody 
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg2 saveEmp(Employee employee) {
		
		
		System.out.println(employee);
		employeeService2.updateEmp(employee);
		 
		return Msg2.success();
	}
	
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg2 getEmp(@PathVariable("id") Integer id) {
		
		Employee employee =  employeeService2.getEmp(id);
		return Msg2.success().add("emp", employee); 
	}
	
	
	
	
	//检查用户名是否重名
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg2 checkuser(@RequestParam("empName")String empName) {
		//先判断用户名是否是合法
		String regx =  "(^[0-9]{3}$)";
		if(!empName.matches(regx)) {
			System.out.println(!empName.matches(regx));
			return Msg2.fail().add("va_msg", "用户名是三个数字或者三到四个汉字,后端消息");
		} ;
		
		
		//数据库用户名重复校验
		boolean b =  employeeService2.checkUser(empName);
		if(b){
			return Msg2.success();
		}else {
			return Msg2.fail().add("va_msg", "用户名不可用，后端重名验证");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/emp2", method=RequestMethod.POST)
	@ResponseBody
	public Msg2 saveEmp(@Valid Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			//返回校验失败信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError :errors) {
					System.out.println(fieldError.getField());
					System.out.println(fieldError.getDefaultMessage());
					map.put(fieldError.getField() , fieldError.getDefaultMessage());
			}
			return Msg2.fail().add("errorField", map);
		}
		
		
		employeeService2.saveEmp(employee);
		
		return Msg2.success();
	}
	
	
	
	
	
	
	
	/*
	 * 查询所有员工
	 * */
	@RequestMapping("/emps2")
	@ResponseBody
	public Msg2 getEmpWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,5);
		//紧接着就是分页查询
		
     	List<Employee> emps = employeeService.getAll();
     	//使用PI包装结果，只需要将pageInfo交给页面就可以
     	//封装了详细的分页信息，包括查询数据,连续传入5页
		PageInfo page = new PageInfo(emps,5);
		return Msg2.success().add("pageInfo", page);
		
	}
	
	
	
	
	//@RequestMapping("/emps2")
	public  String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		//查询之前只需要调用(pn,分页容量)
		PageHelper.startPage(pn,5);
		//紧接着就是分页查询
		
     	List<Employee> emps = employeeService.getAll();
     	//使用PI包装结果，只需要将pageInfo交给页面就可以
     	//封装了详细的分页信息，包括查询数据,连续传入5页
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		System.out.println("到达emps2");
		return "list2";
	}
	
		/*@RequestMapping("/emps2_list3")
		public  String getEmps_list3() {
			
			System.out.println("到达emps2_list3");
			return "list3";
		}*/
	
	
	
}
