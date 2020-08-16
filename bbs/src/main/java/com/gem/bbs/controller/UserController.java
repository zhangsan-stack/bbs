package com.gem.bbs.controller;

import com.gem.bbs.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import com.gem.bbs.entity.User;

import java.util.Date;

//作用：你给你的目标方法参数的Map集合中放入map.setAttribute("myMaster", master),表示在request中加入master
//同事,同时在session中也放入master
// @SessionAttributes表示设置一个session属性，myMaster表示session属性名是myMaster

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        System.out.println("进入deleteById这个controller");
        userService.deleteById(id);
        return "101";
    }

    //去往login界面
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    //去往注册界面
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }


    //这个地方使用shiro重构，session交给shiro进行管理
    @RequestMapping("/login")
    public String login(String username, String password) throws Exception {
        System.out.println("进入shirod接管的login " + username + "___" + password);

        Subject currentUser = SecurityUtils.getSubject();

        //若没有认证
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                //执行验证登录
                currentUser.login(token);
                User user = (User) currentUser.getPrincipal();
                Session session1 = currentUser.getSession();
                session1.setAttribute("user", user);

                System.out.println("已经设置session");
                return "index2";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "login";
    }



    //注册请求
    @RequestMapping("/register")
    public String register(User user){
        System.out.println("进入处理register的controller");
        //设置创造日期为当前时间
        user.setCreatetime(new Date());
        userService.register(user);
        return "redirect:/index.jsp";
    }
    //安全退出

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }

}
