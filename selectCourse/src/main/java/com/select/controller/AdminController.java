package com.select.controller;


import com.select.entity.Admin;
import com.select.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;


    //去往登录界面
    @RequestMapping("/gotoLogin")
    public String gotoLogin(){
        return "login";
    }

    //验证登录请求,并且存入session
    @RequestMapping("/login")
    public String checkLogin(Integer id, String password , HttpServletRequest request){
        System.out.println(id + "__" + password);
        Admin admin = adminService.selectById(id);
        System.out.println(admin.getPassword());
        if((admin != null)  &&  (admin.getPassword().equals(password))){
            //将用户信息存入session中
            request.getSession().setAttribute("admin",admin);

                return "admin";
        }else{
            return "redirect:/index.jsp";
        }

    }

    @RequestMapping("/goto_addCourse")
    public String goto_addCourse(){
        return "addCourse";
    }


}
