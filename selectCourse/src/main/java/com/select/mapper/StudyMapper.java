package com.select.mapper;

import com.select.entity.Study;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudyMapper {

	Study check(@Param("s_id")Integer s_id, @Param("c_id") Integer c_id);

	void insertStudy(Study study);

	List<Study> selectAllStudyBy_c_id(@Param("c_id") Integer c_id);

	List<Study> selectStudiesBy_s_id(@Param("s_id") Integer s_id);
}
