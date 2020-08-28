package com.wdjr.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.bean.EmployeeExample;
import com.wdjr.crud.bean.EmployeeExample.Criteria;
import com.wdjr.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

//	ע��do
	@Autowired
	EmployeeMapper  employeeMapper;
	
	public List<Employee> getAll() {
		// ��ȡ����Ա������
		return employeeMapper.selectByExampleWithDept(null);
	}

	/* Ա�����淽�� */	
	public void saveEmp(Employee employee) {
		
		employeeMapper.insertSelective(employee);
	}
	
	/* Ա���Ƿ���� */	
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}

	/* ��ѯԱ��  */
	public Employee getEmp(Integer id) {
		Employee emp = employeeMapper.selectByPrimaryKey(id);
		return emp;
	}
	
	/* �������Ա�� */
	public void updateEmp(Employee employee) {
		
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/* ɾ��Ա�� */
	public void deleteEmp(Integer id) {
		
		employeeMapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void delteBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria creatia = example.createCriteria();
		//delete from xx where emp_id in (1,2,3)
		creatia.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
		
	}

	public void deleteBatch(List<Integer> empIds) {
		// TODO Auto-generated method stub
		
		EmployeeExample example = new EmployeeExample();
		Criteria criteria  = example.createCriteria()  ;
		criteria.andEmpIdIn(empIds);
		
		employeeMapper.deleteByExample(example);
		
		
		
	}
}
