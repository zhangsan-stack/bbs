package com.wdjr.crud.test;


import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wdjr.crud.bean.Department;
import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.dao.DepartmentMapper;
import com.wdjr.crud.dao.EmployeeMapper;



/*
 * ����mapper
 * �Ƽ�spring��Ŀʹ��spring�ĵ�Ԫ���ԣ������Զ�ע�����
 * 1.����spring��Ԫ����
 * 2.@ContextConfigurationָ��Spring�����ļ���λ��
 * 3.ֱ��autowired
 * */
//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession sqlSession;
	/*
	 * ����mapper
	 * �Ƽ�spring��Ŀʹ��spring�ĵ�Ԫ���ԣ������Զ�ע�����
	 * */
	@Test
	public void testCRUD() {

//		System.out.println(departmentMapper);
		//1.��ѯ��������
		
//		Department dept = departmentMapper.selectByPrimaryKey(1);
		Employee emp = employeeMapper.selectByPrimaryKeyWithDept(1);
		System.out.println(emp.getDepartment().getDeptName());
		
//		System.out.println(dept.getDeptName());
//		departmentMapper.insertSelective(new Department(null,"�з�2��"));
//		System.out.println("����ɹ�");
//		//2.��������
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for (int i = 0; i < 1000; i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
//			employeeMapper.insertSelective(new Employee(null ,uuid,"M",uuid+"@163.com",1));
//	}
//		System.out.println("�������");
	}
	
}
