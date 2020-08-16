package com.gem.bbs.service.impl;


import com.gem.bbs.entity.User;
import com.gem.bbs.mapper.UserMapper;
import com.gem.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    //添加用户
    @Override
    public void register(User user) {
        System.out.println("进入处理register的service");
        System.out.println(user);
        userMapper.insert(user);
        System.out.println("处理register的service已经添加User");
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("进入deleteById这个service");
        userMapper.deleteById(id);
    }



    //通过service层，把从数据库得到的信息，存贮在session中，供给问题表使用
    //登录校验
    @Override
    public String login(String loginname, String password, HttpSession session) {
        System.out.println("进入userServiceImpl验证");
        //查询用户
        User user = userMapper.findUserByLoginname(loginname);
        //如果用户名不为空，并且密码是正确的
        if( (user != null) && user.getPassword().equals(password)){
                //System.out.println("登录成功,返回101");
                session.setAttribute("user", user);
                return "101";
        }else{
            System.out.println("登录失败，返回102");
            return "102";
        }
    }


    //通过登录名，查询用户
    @Override
    public User findUserByLoginname(String loginname) {
        return userMapper.findUserByLoginname(loginname);
    }
}
