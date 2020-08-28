package com.select.controller;


import com.select.entity.Course;
import com.select.entity.Student;
import com.select.entity.Study;
import com.select.service.CourseService;
import com.select.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/study")
@Controller
public class StudyController {

	@Autowired
	StudyService studyService;

	@Autowired
	CourseService courseService;


	//学生自己的选课列表

	@RequestMapping("/showMyCourses")
	public String showMyCourses(Integer s_id,HttpServletRequest request){

		if(s_id != null ){
			List<Study> studies= studyService.selectStudiesBy_s_id(s_id);

			request.getSession().setAttribute("studies",studies);

		}else{
			//如果没有登录，就返回登录界面
			return "login";
		}

		return "show_student_allCourses";

	}

	//根据学生id和课程id，进行学生删除该门课程的函数
	@RequestMapping("/deleteStudyBy_s_id_c_id")
	public String  deleteStudyBy_s_id_c_id(Integer s_id, Integer c_id){
		//获取学生id和课程id，根据这两个数据，删出数据库中，对应的一条数据
		//1,删除study表的一条数据，2更新course表的selected数据
		// 3，redirect至一个新的控制器,并且把学生的s_id也传给下一个页面，也就是让页面刷新一下

		studyService.deleteStudyBy_s_id_c_id(s_id, c_id);

		Course course  = courseService.selectCourseById(c_id);
		course.setSelected(course.getSelected()-1);

		courseService.updateCourse(course);


		return "redirect:/study/showMyCourses?s_id="+s_id;

	}


}
