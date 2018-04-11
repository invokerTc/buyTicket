package com.wwwy.liuxing.user.dao.impl;

import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.dao.IUserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/10.
 */
@Repository
@Transactional
public class UserDao extends SqlSessionDaoSupport implements IUserDao {


    /*
    *全局唯一sqlSessionFactory，交由spirng管理
    * */
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public UserDTO getNameAndPassWord(String userName) throws Exception {
        return getSqlSession().selectOne("com.wwwy.liuxing.user.dto.UserMapper.getNameAndPassWord",userName);
    }

    public UserDTO setUserDto() throws Exception {
        return null;
    }
}
