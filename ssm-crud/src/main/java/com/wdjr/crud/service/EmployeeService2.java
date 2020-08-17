package com.wdjr.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.bean.EmployeeExample;
import com.wdjr.crud.bean.EmployeeExample.Criteria;
import com.wdjr.crud.dao.EmployeeMapper;

@Service
public class EmployeeService2 {

//	ע��do
	@Autowired
	EmployeeMapper  employeeMapper;
	
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	//�����û����Ƿ�����
	
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example  = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count =  employeeMapper.countByExample(example);
		
		return count == 0;
	}

		//����id��ѯԱ����Ϣ
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee =  employeeMapper.selectByPrimaryKey(id);
		
		return employee;
	}
	
	//Ա�����·���
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
		
		
	}

	public void deleteEmp(Integer empId) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(empId);
	}
	
	

	
	
	
}
