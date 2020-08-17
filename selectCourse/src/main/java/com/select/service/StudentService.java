package com.select.service;

import com.select.entity.Student;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudentService {
	void insertStudent(Student student);

	List<Student> selectAll();

	Student selectById(Integer id);

	void updateStudent(Student student);
	void deleteById(Integer id);

	int selectCourseFinally(Integer s_id, Integer c_id);


}
