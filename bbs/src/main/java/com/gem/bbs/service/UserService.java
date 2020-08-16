package com.gem.bbs.service;
import com.gem.bbs.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    //注册用户

    void register (User user);

    void deleteById(Integer id);

    //用户登录
    String login(String loginname, String password, HttpSession session);

    User findUserByLoginname(String loginname);

}
