package com.wwwy.liuxing.hall.controller;

import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.service.IHallService;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的controller层
 */
@Controller
@RequestMapping("/hall")
public class HallController {
    private static final Logger logger = Logger.getLogger(HallController.class);
    @Autowired
    private IHallService hallService;
    @Autowired
    private  ITheaterService theaterService;

    @RequestMapping("/getHall")
    public String getHallInfo(String theaterId, String hallId, ModelMap modelMap){
        logger.info("这里是/hall/getHall controller层路径 ");
        try {
            HallDTO hallDTO = hallService.queryHallByTheaterIdAndHallId(theaterId, hallId);
            logger.info("controller层从数据库取得影厅数据："+hallDTO.getHallName());
            modelMap.put("hallDTO",hallDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_liuxing_cinema_hall_seat";
    }
    @RequestMapping("/getMovieHall")
    public String getMovieHall(String cityId,String theaterId,String movieId,ModelMap modelMap){
        logger.info("这是 /getMovieHall 方法");
        try {
            TheaterDTO theaterDTO = theaterService.queryTheaterById(Integer.parseInt(theaterId));
            modelMap.put("theaterDTO",theaterDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_pick_movie";
    }
}
