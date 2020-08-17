package com.select.controller;

import com.select.entity.Test;
import com.select.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    TestService testService;
    @RequestMapping("/insert")
    public String insert(String username, String password){ System.out.println(username + "__" + password);
       Test test = new Test();
       test.setUsername(username);
       test.setPassword(password);
       System.out.println(test);
       testService.insert(test);
       return "admin";
    }

}
