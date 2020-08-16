package com.gem.bbs.service.impl;

import com.gem.bbs.entity.Problem;
import com.gem.bbs.entity.User;
import com.gem.bbs.mapper.ProblemMapper;
import com.gem.bbs.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    ProblemMapper problemMapper;

    @Override
    public void insert(Problem question, HttpSession session) {
        System.out.println("进入QuestionServiceImpl");
        question.setCreatetime(new Date());
        //强制类型转换
        User user = (User) session.getAttribute("user");

        //得到是谁发的帖子，然后从sessio中获取他的userid，这个userid作为问题表的发布人，也就是userid
        question.setUserid(user.getId());

        System.out.println(question + "___from QuestionServiceImpl");
        problemMapper.insert(question);
        System.out.println("插入数据成功，离开QuestionServiceImpl");
    }

    //返回符合条件的title
    @Override
    public List<Problem> selectAll( String firsttitle) {
        return problemMapper.selectAll(firsttitle);
    }

    //返回总页数
    @Override
    public Integer getTotal(String firsttitle) {
        Integer total = problemMapper.getTotal(firsttitle);
        return total;
    }


}
