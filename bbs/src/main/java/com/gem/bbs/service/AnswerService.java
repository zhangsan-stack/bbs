package com.gem.bbs.service;

import com.gem.bbs.entity.Answer;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AnswerService {
    void insert(Answer answer, HttpSession session, Integer questionid);
    List<Answer> getTotalAnswerById(Integer questionid);
}
