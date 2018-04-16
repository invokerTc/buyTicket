package com.wwwy.liuxing.arth.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dao.IAreaTheaterDAO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.arth.service.IAreaTheaterService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
@Controller
@RequestMapping("/areaTheater")
public class AreaTheaterController {

    @Autowired
    private IAreaTheaterService areaTheaterService;

    @Autowired
    private IAreaTheaterDAO areaTheaterDAO;


    @RequestMapping("/all")
    public String queryAll(HttpServletRequest request, ModelMap modelMap){
        String pageStr = request.getParameter("page");
        if(null==pageStr){
            pageStr= SysConfig.BeforeConfig.PAGE_STR;
        }
        Integer page = Integer.parseInt(pageStr);
        PageInfo<AreaDTO> pageInfo1=null;
        try {
            PageInfo<AreaTheaterDTO> pageInfo = areaTheaterService.queryAll(page);
            List<AreaTheaterDTO> areaTheaterDTOList = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaTheaterDTOList",areaTheaterDTOList);
            return "hou_areaTheater_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }

    }
}
