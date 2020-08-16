package com.gem.bbs.controller;

import com.gem.bbs.entity.Likes;
import com.gem.bbs.service.LikesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/likes")
@Controller
public class LikesController {

    @Resource
    LikesService likesService;


    //这个注解可以返回jsion数据
    @ResponseBody
    @RequestMapping("/insert")
    private String insert(Likes likes) {
        System.out.println(likes);

        likesService.insert(likes);
        return "101";
    }
}


