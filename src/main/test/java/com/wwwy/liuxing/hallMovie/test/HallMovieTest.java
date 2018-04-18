package com.wwwy.liuxing.hallMovie.test;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.dto.dao.IHallMovieDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wanghao on 2018/4/14.
 * 测试HallMovie dao 层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class HallMovieTest {
    private static final Logger logger = Logger.getLogger(HallMovieTest.class);
    @Autowired
    private IHallMovieDao hallMovieDao;

    /**
     * 测试 
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     */
    @Test
    public void testGetLowestMoviePrice(){
        try {
            HallMovieDTO hallmovie = hallMovieDao.getLowestMoviePrice(1,1,1);
            logger.info(hallmovie.getMoviePrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
