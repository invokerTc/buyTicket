package com.wwwy.liuxing.area.test;

import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by W1665 on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class AreaTest {

    private static final Logger logger = Logger.getLogger(AreaTest.class);

    @Autowired
    private IAreaDAO areaDAO;

    @Autowired
    private IAreaService areaService;

    @Test
    public void testQueryAllAreaByDAO(){
        List<AreaDTO> list = areaDAO.queryAllArea();
        logger.debug(list.size());
        for (AreaDTO area :
                list) {
            logger.debug(area.getAreaName());
        }
    }

   @Test
    public void testQueryAllAreaByService(){
       List<AreaDTO> list = areaService.queryAllArea();
       logger.debug(list.size());
       for (AreaDTO area :
               list) {
           logger.debug(area.getAreaName());
       }
   }

}
