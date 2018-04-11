package com.wwwy.liuxing.user.realm;

import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro对账号进行管理认证，权限
 * Created by Administrator on 2018/4/11.
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;

    /*
    * 重写AuthorizingRealm里面的构造
    * */
    @Override
    public String getName() {
        return "UserRealm";
    }

    /*
    * 后台管理的权限管理方法
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*
    * 前台登录验证账号密码方法
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        String passwords = new String(password, 0, password.length);
        SimpleAuthenticationInfo simpleAuthenticationInfo =null;
        UserDTO userDTO =null;
        try {
            userDTO = userService.checkUserNameAndPassWord(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("账号异常");
        }
        if (username==null){
            throw new UnknownAccountException("用户名不存在");
        }
        SimpleHash md5 = new SimpleHash("MD5", passwords, userDTO.getUserName());
        String userPassword = userDTO.getUserPassword();
        if (userPassword==null||!userPassword.equals(md5.toString())){
            throw new IncorrectCredentialsException("密码错误");
        }
        simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, passwords, getName());
        return simpleAuthenticationInfo;
    }
}
