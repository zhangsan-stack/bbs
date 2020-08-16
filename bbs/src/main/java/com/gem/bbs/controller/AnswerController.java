package com.gem.bbs.controller;


import com.alibaba.fastjson.JSON;
import com.gem.bbs.entity.Answer;
import com.gem.bbs.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AnswerController {
    @Resource
    private AnswerService answerService;

    //保存回复的信息
    @RequestMapping("/answer_question")
    public String gotoIndex2(Answer answer, HttpSession session, Integer questionid){
        System.out.println(questionid + "__from AnswerController");
        answerService.insert(answer, session,questionid );

        return "index2";
    }

    //接受从detail页面的问题id，从数据库得到帖子回复信息，再返回给detail.jsp页面
    @ResponseBody
    @RequestMapping("/getTotalAnswerById")
    public List<Answer> getTotalAnswerById(Integer questionid,  Model model ){
        //可能会报数据类型错误
        System.out.println(questionid + "__from AnswerController");
        List<Answer> total_answer = answerService.getTotalAnswerById(questionid);
       //把的到的数据list<对象>数据转换为json字符串

        /*String ListUserJson = JSON.toJSONString(total_answer);
        System.out.println(ListUserJson);*/

        return total_answer;

    }


}
