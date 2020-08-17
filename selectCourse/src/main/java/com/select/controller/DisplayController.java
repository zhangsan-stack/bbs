package com.select.controller;

import com.select.entity.Course;
import com.select.entity.Student;
import com.select.service.AdminService;
import com.select.service.CourseService;
import com.select.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.select.utils.Page;


import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller()
public class DisplayController {

    @Resource
    AdminService adminService;

    @Resource
    CourseService courseService;


    @Resource
	StudentService studentService;

    @RequestMapping("/adminindex")
    public String adminindex(HttpServletRequest request){
        if(request.getSession().getAttribute("id") ==null){
            return "login";
        }
        return "admin";
    }


    /*@RequestMapping("/courseManager")
    public String courseManager(@RequestParam(defaultValue = "1")Integer page,
                                @RequestParam(defaultValue = "5")Integer rows, HttpServletRequest request, Model model){
        if(request.getSession().getAttribute("admin") == null){
            return "login";
        }
        Page<Course> courses = courseService.getPageAllCourses(page, rows);
        request.getSession().setAttribute("courses", courses.getRows());
        model.addAttribute("page", courses);

        return "allCourses";

    }
*/

	@RequestMapping("/courseManager")
	public String courseManager(HttpServletRequest request, Model model){
		if(request.getSession().getAttribute("admin") == null){
			return "login";
		}
		//查询所有，而不是份额与
		List<Course> courses = courseService.getAllCourses();

		request.getSession().setAttribute("courses", courses);
		//返回所有课程的页面
		return "allCourses";

	}

	@RequestMapping("/allStudents")
	public String allStudents(HttpServletRequest request, Model model){
		//如果没有登录，则返回登录界面
		if(request.getSession().getAttribute("admin") == null){
			return "login";
		}
		//查询所有学生，返回List<学生对象>
		List<Student> students =studentService.selectAll();

		request.getSession().setAttribute("students", students);

		return "allStudents";
	}


}
