package com.gem.bbs.mapper;

import com.gem.bbs.entity.Answer;

import java.util.List;

public interface AnswerMapper {
    void insert(Answer answer);
    //返回值类型为Answer
   List<Answer> getTotalAnswerById(Integer questionid);
}
