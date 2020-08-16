package com.gem.bbs.controller;

import com.gem.bbs.entity.Answer;
import com.gem.bbs.entity.Problem;
import com.gem.bbs.service.ProblemService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/ques")
public class ProblemController {
    @Resource
    private ProblemService questionService;

    //去往表单页面
    @RequestMapping("/form")
    public String gotoForm(){
        return "questionForm";
    }



    @RequestMapping("/save")
    public String save(Problem question, HttpSession session){

        System.out.println("进入QuestionController");
        System.out.println(question + "__from 进入QuestionController");

        questionService.insert(question, session);
        System.out.println("插入数据已经完成，现在离开QuestionController，去往index.jsp");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/delete")
    public String  deleteById(Integer id)
    {
        return "questionForm";
    }


    //怎么得到上个动态页面的帖子信息，并且传送给下一个页面
    @RequestMapping("/detail")
    public String gotoDetail(String firsttitle, String questionid, Model model){
        //把获得的数据，传送给detail
        System.out.println(firsttitle  +"__"+ questionid + "__from__ProblemController");
        model.addAttribute("firsttitle", firsttitle);
        model.addAttribute("questionid", questionid);
        return "detail";
    }

}
