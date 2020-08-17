package com.select.service.impl;

import com.select.entity.Course;
import com.select.mapper.CourseMapper;
import com.select.service.CourseService;
import com.select.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;


    @Override
    public Boolean insertCourse(Course course) {
        String name = course.getName();
        if(name !=null && name.length()<=100){
            courseMapper.insertCourse(course);
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public Course selectCourseById(Integer id) {

        return courseMapper.selectCourseById(id);
    }

    @Override
    public Boolean updateCourse(Course course) {

        if( (course != null) && (course.getId()!=null) ){
            courseMapper.updateCourse(course);
            return true;
        }else{
            return false;
        }
    }


    //获取所有课程，没有任何条件
    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();

    }


    //返回所有的课程列表，并且分页
    @Override
    public Page<Course> getPageAllCourses(Integer page, Integer rows) {

        Map<String ,Object> map = new HashMap<String ,Object>();
        //获取集合的大小，也就是course的总个数
        int total  = courseMapper.getAllCourses().size();
        //分页处理
        map.put("pageNo", (page-1) * rows);
        map.put("rows", rows);
        Integer pageNo = (page -1) * rows;

        List<Course> list = courseMapper.getPageAllCourses(pageNo, rows);

        //new一个新的Page<Course>，存放后端传来的分页数据
        Page<Course> result = new Page<Course>();

        result.setPage(page);
        result.setSize(rows);
        result.setRows(list);
        result.setTotal(total);

        return  result;

    }

	@Override
	public void deleteById(Integer id) {
    	courseMapper.deleteById(id);
	}
}
