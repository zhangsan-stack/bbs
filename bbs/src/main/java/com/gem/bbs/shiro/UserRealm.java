package com.gem.bbs.shiro;
import com.gem.bbs.entity.User;
import com.gem.bbs.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.concurrent.locks.Lock;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    public String getName(){
        return "UserRealm";
    }
        //授权
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            return null;
        }
        //认证
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token ) throws AuthenticationException {
            System.out.println("doGetAuthenticationInfo__" + token.hashCode() +": 2__");

            String username =(String ) token.getPrincipal();

            User sysUser = userService.findUserByLoginname(username);
            if(sysUser == null){
                return null;
            }

            //数据库中获取的密码
            String password = sysUser.getPassword();
            User user = new User();
            user.setId(sysUser.getId());
            user.setLoginname(sysUser.getLoginname());
            user.setUsername(sysUser.getUsername());


            //当前realm的名称
            String realmName = getName();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
            System.out.println("准备离开realm");
            return info;
        }
}
