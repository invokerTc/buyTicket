package com.wwwy.liuxing.hallMovie.test;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    /**
     * 测试String转换成date格式
     */
    @Test
    public void testQueryPlayingHallMovie(){
        try {
            List<HallMovieDTO> list = hallMovieDao.queryPlayingHallMovie(1, 1, 1);
            for (HallMovieDTO hm:list) {
                String movieRuntime = hm.getMovieRuntime();
//                logger.info(movieRuntime);
                String time = movieRuntime+":00";
                logger.info(time);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date time1 = sdf.parse(time);
                logger.info(time1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testDate(){
        String time = "2018-4-18 18:11:23";
        String time2= "2018-4-18 14:11:23";
        Date date = new Date(time);
        Date date1 = new Date(time2);

    }
}
