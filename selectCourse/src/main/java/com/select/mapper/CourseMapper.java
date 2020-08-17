package com.select.mapper;

import com.select.entity.Course;
import com.select.utils.Page;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSInput;
import sun.rmi.server.InactiveGroupException;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
     void insertCourse(Course course);

     Course selectCourseById(Integer id);

     void updateCourse(Course course);
     //获取所有
     List<Course> getAllCourses();
     //分页查询结果
     List<Course> getPageAllCourses(@Param("pageNo") Integer pageNo, @Param("rows") Integer rows);
	 void deleteById(Integer id);
}
