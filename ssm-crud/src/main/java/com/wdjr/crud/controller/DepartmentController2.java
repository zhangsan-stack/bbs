package com.wdjr.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdjr.crud.bean.Department;
import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.bean.Msg2;
import com.wdjr.crud.service.DepartmentService;
import com.wdjr.crud.service.DepartmentService2;
import com.wdjr.crud.service.EmployeeService;

/**
 * 处理和部门有关的请求
 * 
 */

@Controller
public class DepartmentController2 {
	
	@Autowired
	private DepartmentService2 departmentService2;
	
	
	
	
	
	
	
	@RequestMapping("/depts2")
	@ResponseBody
	public Msg2 getDepts() {
		//查出的所有部门信息
		List<Department> list =  departmentService2.getDepts();
		System.out.println("depts2");
		return Msg2.success().add("depts2", list);
		
		
	}
	
	
}
