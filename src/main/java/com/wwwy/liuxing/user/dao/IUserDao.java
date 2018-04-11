package com.wwwy.liuxing.user.dao;

import com.wwwy.liuxing.user.dto.UserDTO;

/**
 * Created by Administrator on 2018/4/10.
 */
public interface IUserDao {

    /*
    * 前端用户登录接口
    * */
    UserDTO getNameAndPassWord(String userName)throws Exception;

    /*
    * 前端用户注册接口
    * */
    UserDTO setUserDto()throws Exception;

}
