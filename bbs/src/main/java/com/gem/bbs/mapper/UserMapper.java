package com.gem.bbs.mapper;
import com.gem.bbs.entity.User;

//用户接口
public interface UserMapper {
    //注册，即保存用户
    //登录，根据用户名，密码，在数据库中验证用户是否存在

    void insert(User user);

    void deleteById(Integer id);

    User findUserByLoginname(String loginname );


}
