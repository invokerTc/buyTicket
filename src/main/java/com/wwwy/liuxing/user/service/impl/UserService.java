package com.wwwy.liuxing.user.service.impl;

import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/11.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDTO checkUserNameAndPassWord(String userName) throws Exception {
        return userDao.getNameAndPassWord(userName);
    }

    @Override
    public boolean setUserDTO(UserDTO userDTO) throws Exception {
        String md5 = new SimpleHash("MD5", userDTO.getUserPassword(), userDTO.getUserName()).toString();
        userDTO.setUserPassword(md5);
        Integer i = userDao.setUserDto(userDTO);
        if (i>0){
           return true;
        }
        return false;
    }
}
