package com.gem.bbs.service.impl;

import com.gem.bbs.entity.Answer;
import com.gem.bbs.entity.User;
import com.gem.bbs.mapper.AnswerMapper;
import com.gem.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerMapper answerMapper;



    //这个是有用户登录情况下的添加回复，并且把回复的信息保存进入数据库
    @Override
    public void insert(Answer answer, HttpSession session, Integer questionid) {
        //设置回复帖子的日期
        answer.setCreatetime(new Date());
        //设置需要回复帖子的id号码
        answer.setQuestionid(questionid);
        //通过session获取前端的用户信息，如果没有User表明是匿名回复，则userid为名，如果有User,则正常填写userid
        User user = (User) session.getAttribute("user");
        if(user == null ){
            answer.setUserid(0);
        }else{
            answer.setUserid(user.getId());
        }
        answerMapper.insert(answer);
    }

    @Override
    public List<Answer> getTotalAnswerById(Integer questionid) {
        return  answerMapper.getTotalAnswerById(questionid);
    }
}
