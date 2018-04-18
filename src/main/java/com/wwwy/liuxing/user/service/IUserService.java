package com.wwwy.liuxing.user.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface IUserService {

    UserDTO checkUserNameAndPassWord(String userName)throws Exception;

    boolean setUserDTO(UserDTO userDTO)throws Exception;

    PageInfo<UserDTO> getUserInfo(Integer page)throws Exception;

    boolean updateUserInfo(UserDTO userDTO)throws Exception;

    UserDTO getUserInfoById(Integer userId)throws Exception;

    PageInfo<UserDTO> criteriaQueryUser(String anyInfo, Integer page)throws Exception;
}
