
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class SpringTest {
    private Logger logger = Logger.getLogger(SpringTest.class);
    //    private Logger logger=Logger.getLogger(SpringTest.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testCase1() {
        if (logger.isDebugEnabled()) {
            logger.debug("testCase1-----start");
        }
//        stringRedisTemplate.opsForList().rightPushAll("f4","1","3","5","4");
        List<String> result = stringRedisTemplate.opsForList().range("f4", 0, 100);
        for (String str : result) {
            logger.info(str);
//            System.out.println(str);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("testCase1-----end");
        }
    }

    @Test
    public void testCase4() {
        if (logger.isDebugEnabled()) {
            logger.debug("testCase4--start");
        }
//        stringRedisTemplate.opsForList().rightPushAll("list","1","2","3","4");
        List<String> list1 = stringRedisTemplate.opsForList().range("list", 0, 9);
//        List<String> list = stringRedisTemplate.boundListOps("list").range(0, 10);
        for (String str : list1) {
            logger.info(str);
//            System.out.println(str);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("testCase4--end");
        }
    }
}
