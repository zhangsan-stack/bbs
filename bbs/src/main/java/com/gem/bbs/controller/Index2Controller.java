package com.gem.bbs.controller;

import com.gem.bbs.entity.Problem;
import com.gem.bbs.entity.User;
import com.gem.bbs.service.ProblemService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller()
public class Index2Controller {

    //访问首页
    @Resource
    ProblemService problemService;

    //去往index2这个页面，并且吧回复的信息保存进入数据库
    @RequestMapping("/index2_main")
    public String getIndex2(){

        return "index2";
    }

    //携带数据，去往index2这个页面，这个地方使用shiro重构,session交个了shiro管理
    @RequestMapping("/index2")
    public String  gotoIndex3(String firsttitle,  Model model){
        //获取从数据库读取到的problem数据，存在list中，然后在放入model中，最后传递到index2.jsp这个页面，进行前端显示
        //主体

        List<Problem>  list = problemService.selectAll(firsttitle);

        //将数据放入到request对象中,然后传递给前端
        model.addAttribute("questionList", list);
        model.addAttribute("firsttitle", firsttitle);
        //model作为下一个页面的显示数据
        return "index2";
    }
}
