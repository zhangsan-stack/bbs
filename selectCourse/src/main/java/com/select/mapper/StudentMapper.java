package com.select.mapper;

import com.select.entity.Student;

import java.util.List;

public interface StudentMapper {
	void insertStudent(Student student);
	List<Student> selectAll();
	Student selectById(Integer id);

	//更新
	void updateStudent(Student student);

	void deleteById(Integer id);

}
