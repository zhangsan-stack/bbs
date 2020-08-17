package com.select.service.impl;

import com.select.entity.Course;
import com.select.entity.Student;
import com.select.entity.Study;
import com.select.mapper.CourseMapper;
import com.select.mapper.StudentMapper;
import com.select.mapper.StudyMapper;
import com.select.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	StudyMapper studyMapper;

	@Override
	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	@Override
	public List<Student> selectAll() {
		return studentMapper.selectAll();
	}

	@Override
	public Student selectById(Integer id) {

		return studentMapper.selectById(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateStudent(student);
	}

	@Override
	public void deleteById(Integer id) {
		System.out.println(id + "_from __ StudentServiceImpl__deleteById");
		studentMapper.deleteById(id);
	}



	@Override
	public int selectCourseFinally(Integer s_id, Integer c_id ) {
		//查看人数是否已经满了，该学生是否已经选过该课程

		Course course = courseMapper.selectCourseById(c_id);
		//通过session获取已经登录的学生的信息

		Student student = studentMapper.selectById(s_id);


		if(course != null && student !=null){
			//判断课程是否已经被选完，若没有，则可以选课
			if(course.getSelected() < course.getAmount()){
				Study CheckIfExit = studyMapper.check(s_id, c_id);
				if( CheckIfExit== null){
					//说明没有选过这门课程
					Study study = new Study();

					study.setS_id(s_id);
					study.setS_major(student.getMajor());
					study.setS_name(student.getName());

					study.setC_id(c_id);
					study.setC_name(course.getName());
					study.setC_belong(course.getBelong());
					study.setC_credit(course.getCredit());
					study.setC_time(course.getTime());

					//选课成功，在study表，插入一条新的记录
					studyMapper.insertStudy(study);
					//并且把该门课程的已选人数加一，并且更新
					course.setSelected(course.getSelected()+1);
					courseMapper.updateCourse(course);
					return 0;
				}else{
					return 1;
				}
			}else {
				return 2;
			}
		}
		return -1;
	}

}
