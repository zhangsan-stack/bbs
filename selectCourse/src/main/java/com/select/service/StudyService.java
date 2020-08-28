package com.select.service;

import com.select.entity.Study;

import java.util.List;

public interface StudyService {

	List<Study> selectAllStudyBy_c_id(Integer c_id);

	List<Study> selectStudiesBy_s_id(Integer s_id);

	void deleteStudyBy_s_id_c_id(Integer s_id, Integer c_id);

}
