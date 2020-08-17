package com.select.controller;

import com.select.entity.Study;
import org.apache.commons.io.FileUtils;
import com.select.entity.Course;
import com.select.service.CourseService;
import com.select.utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {
    public static SimpleDateFormat df = new SimpleDateFormat("yyyyMM");


    @Autowired
    CourseService courseService;


    //添加课程
    //支持文件上传
    @RequestMapping("/insertCourse")
    public String insertCourse(HttpServletRequest request, MultipartFile file){

        String msg = null;
        String year_moth = df.format(new Date());
        try{
            request.setCharacterEncoding("utf-8");
            Course course = new Course();
            //判断图片是否存在
            /*if(!file.isEmpty()){
                ServletContext sc = request.getSession().getServletContext();
               //设置文件保存的目录
                String dir = sc.getRealPath("/upload/imgurl/"+year_moth);
                //获取文件名称
                String filename = file.getOriginalFilename();
                //组建一个新的文件名
                String tempfilename = Tools.getRndFilename()+Tools.getFileExtName(filename);

                //将新建的文件存入本地硬盘
                FileUtils.writeByteArrayToFile(new File(dir, tempfilename),file.getBytes());
                //将新建的文件地址，放入数据库中
                course.setImgurl("/upload/imgurl/"+year_moth+"/"+tempfilename);
            }*/
            course.setName(request.getParameter("name"));
            course.setSelected(0);
            course.setAmount(Integer.parseInt(request.getParameter("amount")));
            course.setBelong(request.getParameter("belong"));
            course.setCredit(Integer.parseInt(request.getParameter("credit")));
            course.setPlace(request.getParameter("place"));
            course.setDetail(request.getParameter("detail"));
            course.setTime(request.getParameter("time"));

            if(courseService.insertCourse(course)){
                msg = "添加成功";
            }else{
                msg = "添加失败";
            }

        }catch(Exception e){
            e.printStackTrace();
            msg = "添加失败";
        }finally {
            request.getSession().setAttribute("msg", msg);
            return "admin";
        }
    }


    @RequestMapping(value = "/selectCourseById")
    public String selectCourseById(@RequestParam("id") Integer id, HttpServletRequest request){
        Course course = new Course();
        course =  courseService.selectCourseById(id);
        request.getSession().setAttribute("course", course);
        return "editCourse";
    }


    //编辑课程
    @RequestMapping("/editCourse")
    public String editCourse(HttpServletRequest request,  MultipartFile file){
        String msg = null;
        String year_moth = df.format(new Date());
        try{

            Integer id = (Integer) request.getSession().getAttribute("id");
            //这里比较麻烦，是根据前端传来的id从后端重新获取的course，然后存入session作为下一个界面的数据
            Course course = courseService.selectCourseById(id);
           /* if(!file.isEmpty()){
                ServletContext sc = request.getSession().getServletContext();
                //设置文件保存的目录
                String dir = sc.getRealPath("/upload/imgurl/"+year_moth);
                //获取文件名称
                String filename = file.getOriginalFilename();
                //组建一个新的文件名
                String tempfilename = Tools.getRndFilename()+Tools.getFileExtName(filename);
                try{
                    //将新建的文件存入本地硬盘
                    FileUtils.writeByteArrayToFile(new File(dir, tempfilename),file.getBytes());

                }catch (Exception e){
                    e.printStackTrace();
                }*/
                //将新建的文件地址，放入数据库中
               /* course.setImgurl("/upload/imgurl/"+year_moth+"/"+tempfilename);*/
                course.setName(request.getParameter("name"));
                course.setSelected(0);
                course.setAmount(Integer.parseInt(request.getParameter("amount")));
                course.setBelong(request.getParameter("belong"));
                course.setCredit(Integer.parseInt(request.getParameter("credit")));
                course.setPlace(request.getParameter("place"));
                course.setDetail(request.getParameter("detail"));
                course.setTime(request.getParameter("time"));

                //在这里进行更新
                if(courseService.updateCourse(course)){
                    msg = "更新课程成功";
                }else{
                    msg="失败";
                }

            } catch ( Exception e){
            e.printStackTrace();
        }finally {
            request.getSession().setAttribute("msg", msg);
            return "admin";
        }

    }


	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("id") Integer id, HttpServletRequest request){
    	if(id !=null){
			courseService.deleteById(id);
			System.out.println("要删除的课程id是：" +id);
			request.getSession().setAttribute("msg", "删除成功");
		}else{
			request.getSession().setAttribute("msg", "删除失败");
		}

		return  "allCourses";


    }

    //去往学生选课界面
	@RequestMapping("/gotoSelectCourse")
	public String gotoSelectCourse(HttpServletRequest request){

		System.out.println("进入SelectCourseController的"+ "goto_index"+"这个函数");
		//验证学生是否已经登录，如果没有返回学生登录界面
		if(request.getSession().getAttribute("student") == null){
			return "student_login";
		}
		//前台首页,显示所有的课程，供给学生选课
		List<Course> courses= courseService.getAllCourses();
		request.getSession().setAttribute("courses", courses);

		return "SelectCourse";

	}

	//去往课程详情界面
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, HttpServletRequest request){
    	//加一个保险，只有学生登录才能访问该页面
    	if(request.getSession().getAttribute("student") == null){
    		return "student_login";
		}

		Course course = courseService.selectCourseById(id);
		request.getSession().setAttribute("course", course);

    	return "courseDetail";

	}










}
