package com.wwwy.liuxing.user.controller;

import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 登录shiro
     */
    @RequestMapping("/login")
    @ResponseBody
    public String userLogin(String userName, String passWord, Model model){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            //将用户输入的参数传给Realm验证
            subject.login(usernamePasswordToken);
            //可以调用登录用户名称传到前端页面
            model.addAttribute("userName", userName);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return "{\"code\":0}";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "{\"code\":2}";
        }
        return "{\"code\":1}";
    }

    /*
    * 用户注册
    * */
    @RequestMapping("/register")
    @ResponseBody
    public String userRegister(UserDTO userDTO){
        try {
            boolean dto = userService.setUserDTO(userDTO);
            if (dto){
                return "{\"code\":1}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"code\":0}";
        }
        return "";
    }
}
