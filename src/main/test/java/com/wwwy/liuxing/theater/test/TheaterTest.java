package com.wwwy.liuxing.theater.test;

import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class TheaterTest {
    private static final Logger logger = Logger.getLogger(TheaterTest.class);
    @Autowired
    private ITheaterDAO theaterDAO;
    @Autowired
    private ITheaterService theaterService;
    @Test
    public void testCase1(){
        try {
            List<TheaterDTO> theaterDTOs = theaterService.queryTheaterByPattern("中");
            for (TheaterDTO theater:theaterDTOs) {
                if (logger.isInfoEnabled()){
                    logger.info(theater.getTheaterName()+"=========="+theater.getTheaterAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryLowestPriceTheaterList(){
        try {
            List<TheaterDTO> theaterDTOs = theaterDAO.queryLowestPriceTheaterList(1, 1);
            for(TheaterDTO th:theaterDTOs){
                logger.info(th.getTheaterName()+"\t"+th.getTheaterAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
