package com.wwwy.liuxing.theater.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.city.service.ICityService;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/14
 */
@Controller
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private ITheaterService theaterService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IAreaService areaService;

    private static final Logger logger = Logger.getLogger(TheaterController.class);


    @RequestMapping("/cityArea")
    public String queryCityAndArea(HttpServletRequest request,ModelMap modelMap){
        String cityName = request.getParameter("cityName");
        try {
        if(null!=cityName){
            CityDTO cityDTO = cityService.queryCityByName(cityName);
            List<AreaDTO> areaDTOList = areaService.queryAllArea(cityDTO.getCityId());
            modelMap.addAttribute("areaDTOList",areaDTOList);
        }
        List<CityDTO> cityDTOList = cityService.queryAllCity();
        modelMap.addAttribute("cityDTOList",cityDTOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_theater_list";
    }

    /**
     * 根据地区查询出所有的电影院并分页
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/all")
    public String queryAllTheaterByAreaId(HttpServletRequest request,ModelMap modelMap){
        String pageStr = request.getParameter("page");
        String areaName = request.getParameter("areaName");
        logger.debug("areaId======"+areaName);
        Integer page = Integer.parseInt(pageStr);
        try {
            PageInfo<TheaterDTO> pageInfo = theaterService.queryAllTheater(areaName, page);
            List<TheaterDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("theaterList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
        }
        return "hou_theater_list";
    }
}
