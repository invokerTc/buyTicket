package com.wwwy.liuxing.user.service;

import com.wwwy.liuxing.user.dto.UserDTO;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface IUserService {

    UserDTO checkUserNameAndPassWord(String userName)throws Exception;
}
