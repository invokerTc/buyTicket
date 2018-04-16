package com.wwwy.liuxing.user.test;


import com.wwwy.liuxing.admin.dao.IAdminDao;
import com.wwwy.liuxing.admin.dto.AdminDto;
import com.wwwy.liuxing.admin.service.IAdminService;
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
    private IAdminDao adminDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserService userService;


    @Autowired
    private IAdminService adminService;

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

    @Test
    public void testAdminDao(){
        try {
            AdminDto zhangsan = adminDao.getNameAndPassWord("dsdasd");
            logger.info("=============="+zhangsan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdminService(){
        try {
            AdminDto zhangsan = adminService.checkUserNameAndPassWord("zhangsan", "`12qwe");
            logger.info(zhangsan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
