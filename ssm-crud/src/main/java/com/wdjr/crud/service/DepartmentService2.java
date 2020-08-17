package com.wdjr.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdjr.crud.bean.Department;
import com.wdjr.crud.dao.DepartmentMapper;

@Service
public class DepartmentService2 {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts(){
		List<Department> list  = departmentMapper.selectByExample(null);
		
		return list;
	}
	
	
}
