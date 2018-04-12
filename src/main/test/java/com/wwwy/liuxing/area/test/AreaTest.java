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
        List<AreaDTO> list = null;
        try {
            list = areaDAO.queryAllArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(list.size());
        for (AreaDTO area :
                list) {
            logger.debug(area.getAreaName());
        }
    }

   @Test
    public void testQueryAllAreaByService(){
       List<AreaDTO> list = null;
       try {
           list = areaService.queryAllArea(1);
       } catch (Exception e) {
           e.printStackTrace();
       }
       logger.debug(list.size());
       for (AreaDTO area :
               list) {
           logger.debug(area.getAreaName());
       }
   }

    @Test
    public void testInsertArea(){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaName("nihao");
        areaDTO.setFkCityId(1);
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.insertArea(areaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testDelete(){
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.deleteArea(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testUpdate(){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(16);
        areaDTO.setAreaName("hah");
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.updateArea(areaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

}
