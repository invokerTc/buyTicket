package com.wwwy.liuxing.user.test;


import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class UserTest {

    private static final Logger logger = Logger.getLogger(UserTest.class);


    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserService userService;

    @Test
    public void testLogin(){
        UserDTO zhangsan = null;
        try {
            zhangsan = userDao.getNameAndPassWord("laoyang");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(zhangsan);
    }

    @Test
    public void testLoginService(){
        try {
            UserDTO userNameAndPassWord = userService.checkUserNameAndPassWord("zhangsan");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
