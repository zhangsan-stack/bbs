package com.wdjr.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdjr.crud.bean.Department;
import com.wdjr.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;
	//��ȡ���в�����Ϣ
	public List<Department> getDepts() {
		// ��ȡ����Ա������
		return departmentMapper.selectByExample(null);
	}
}
