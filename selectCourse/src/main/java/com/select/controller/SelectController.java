package com.select.controller;

import com.select.entity.Course;
import com.select.entity.Student;
import com.select.service.CourseService;

import com.select.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/select")
public class SelectController {

	@Resource
	CourseService courseService;
	@Resource
	StudentService studentService;

	@RequestMapping("/selectCourseFinally")
	public String selectCourseFinally(Integer id, HttpServletRequest request){
		String msg = null;
		//参数列表里面的is指的是要选课程的id
		//从CourseDetail页面拿到存放在session里面的student对象，然后类型强转
		Student student =(Student) request.getSession().getAttribute("student");
		Integer s_id = student.getId();
		Course course = courseService.selectCourseById(id);

		Integer c_id = course.getId();

		int rst = studentService.selectCourseFinally(s_id, c_id);
		if(rst  == 0){
			msg="选课成功";
		}else if(rst == 1){
			msg ="已近选过此课";
		}else if(rst == 2){
			msg="该课程已经满了";
		}else {
			msg="未知错误";
		}
		request.getSession().setAttribute("msg", msg);

		return "courseDetail";

	}

}
