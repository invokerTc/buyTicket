package com.wwwy.liuxing.user.service.impl;

import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/11.
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDTO checkUserNameAndPassWord(String userName) throws Exception {
        return userDao.getNameAndPassWord(userName);
    }
}
