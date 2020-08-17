package com.select.service.impl;

import com.select.entity.Study;
import com.select.mapper.StudyMapper;
import com.select.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	StudyMapper studyMapper;


	@Override
	public List<Study> selectAllStudyBy_c_id(Integer c_id) {
		System.out.println(c_id +" from service");
		List<Study> studies = studyMapper.selectAllStudyBy_c_id(c_id);
		System.out.println(studies + "from__service");
		return studies;
	}

	@Override
	public List<Study> selectStudiesBy_s_id(Integer s_id) {
		return studyMapper.selectStudiesBy_s_id(s_id);
	}
}
