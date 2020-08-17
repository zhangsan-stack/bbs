package com.select.controller;

import com.select.entity.Student;
import com.select.entity.Study;
import com.select.service.StudentService;
import com.select.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Style;
import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@Autowired
	StudyService studyService;

	@RequestMapping("/goto_insertStudent")
	public String goto_insertStudent(){

		return "insertStudent";
	}

	@RequestMapping("/insertStudent")
	public String  insertStudent(Integer id, String name, String password,
								 String sex, String year, String  major){
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPassword(password);
		student.setSex(sex);
		student.setYear(year);
		student.setMajor(major);
		studentService.insertStudent(student);
		return "allStudents";
	}

	@RequestMapping("/editStudent")
	public String editStudent(Integer id, HttpServletRequest request){
		//比较笨的方法，通过id从后台拿到这条数据
		Student student = studentService.selectById(id);
		//放到session中，传给下个界面
		request.getSession().setAttribute("student", student);
		return "editStudent";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(Integer id, String name, String password, String sex, String year, String major){

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPassword(password);
		student.setSex(sex);
		student.setYear(year);
		student.setMajor(major);
		System.out.println(student+ "from__studentController");
		//更新数据
		studentService.updateStudent(student);
		return "redirect:/allStudents";
	}

	//根据id删除学生
	@RequestMapping("/deleteById")
	public String deleteById(Integer id){
		System.out.println("deleteById_"+ id);
		studentService.deleteById(id);
		return "redirect:/allStudents";
	}

	//学生登录功能的实现
	@RequestMapping("/goto_login")
	public String goto_login(Integer id, String password, HttpServletRequest request){
		System.out.println("从前端传过来的id: "+ id+ "password: "+ password);
		//注意这里是一个student对象，退出的时候要用的
		Student student = studentService.selectById(id);

		System.out.println(student+ "here is ok");

		if(student != null && student.getPassword().equals(password)){
			request.getSession().setAttribute("student", student);
		}

		//重定向到学生选课界面，注意是重定向,不能直接跳转，否则会有空指针异常
		return "redirect:/gotoSelectCourse";
	}


	//去往学生的登录界面的方法
	@RequestMapping("/goto_student_login")
	public String goto_student_login(){

		return "student_login";
	}


	//退出的方法
	@RequestMapping("/student_logout")
	public String student_logout(HttpServletRequest request){
		request.getSession().setAttribute("student", null);
		return "redirect:/index.jsp";
	}

	//查看选过该课程的学生，没有分页

	@RequestMapping("/show_student_who_selected_this_course")
	public String show_student_who_selected_this_course(Integer c_id,HttpServletRequest request){
		//这c_id，不能直接从session中获取，若是有多个课程，都在session中，就会出错的
		System.out.println(c_id+ "from_controller");
		try {
			//通过c_id,获取带有该c_id的所有记录，组成一个List<Study>，从数据库，返回给前端
			List<Study> studies = studyService.selectAllStudyBy_c_id(c_id);
			System.out.println(studies + "from_controller");
			request.getSession().setAttribute("studies", studies);



		}catch (Exception e){
			e.printStackTrace();
			return "success";
		}


		return "stu_name_list";

	}



}
