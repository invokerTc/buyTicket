package com.wwwy.liuxing.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/11.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/login")
    public String userLogin(String userName, String passWord, HttpServletRequest request){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            //将用户输入的参数传给Realm验证
            subject.login(usernamePasswordToken);
            //可以调用登录用户名称传到前端页面
            request.setAttribute("userName", userName);
        }catch (UnauthenticatedException e){
            e.printStackTrace();
            return "{\"code\":0}";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "{\"code\":2}";
        }
        return "{\"code\":1}";
    }
}
