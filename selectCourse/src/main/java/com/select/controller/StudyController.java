package com.select.controller;


import com.select.entity.Study;
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

	//学生自己的选课列表

	@RequestMapping("/showMyCourses")
	public String showMyCourses(Integer s_id, HttpServletRequest request){
		if(s_id != null ){
			List<Study> studies= studyService.selectStudiesBy_s_id(s_id);

			request.getSession().setAttribute("studies",studies);

		}else{
			//如果没有登录，就返回登录界面
			return "login";
		}

		return "show_student_allCourses";

	}

}
