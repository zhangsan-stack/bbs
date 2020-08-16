package com.gem.bbs.service;

import com.gem.bbs.entity.Problem;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ProblemService {

    //查询新问题
    public void insert(Problem qustion, HttpSession session);

    List<Problem> selectAll(String firsttitle);


    //获取符合title标准的总页数
    Integer getTotal(String firsttitle);

    //获取符合title要求的记录总数



}
