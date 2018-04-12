package com.wwwy.liuxing.area.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/12
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @RequestMapping("/all")
    public String queryAllArea(HttpServletRequest request,ModelMap modelMap){
        String page = request.getParameter("page");
        if(null==page){
            page= SysConfig.BeforeConfig.PAGE_START;
        }
        PageHelper.startPage(Integer.parseInt(page), SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaDTO> areaDTOsList = areaService.queryAllArea();
        PageInfo<AreaDTO> p=new PageInfo<AreaDTO>(areaDTOsList);
        modelMap.addAttribute("page", p);
        modelMap.addAttribute("areaDTOsList",areaDTOsList);
        return "hou_area_list";
    }
}
