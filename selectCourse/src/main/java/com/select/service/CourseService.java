package com.select.service;

import com.select.entity.Course;
import com.select.utils.Page;

import java.util.List;

public interface CourseService {

    Boolean insertCourse(Course course);
    Course selectCourseById(Integer id);
    Boolean updateCourse(Course course);
    //获取所有课程

    List<Course> getAllCourses();

    //分页查询获取所有课程
    Page<Course> getPageAllCourses(Integer page, Integer rows);

	void  deleteById(Integer id);

}
