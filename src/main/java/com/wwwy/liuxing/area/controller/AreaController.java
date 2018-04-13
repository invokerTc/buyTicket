package com.wwwy.liuxing.area.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 查询所有的地区并分页
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/all")
    public String queryAllArea(HttpServletRequest request,ModelMap modelMap){
        String pageStr = request.getParameter("page");
        Integer page=Integer.parseInt(pageStr);
        try {
            PageInfo<AreaDTO> pageInfo = areaService.queryAllArea(SysConfig.BeforeConfig.PAGE_START,page);
            List<AreaDTO> list = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaDTOsList",list);
            return "hou_area_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "hou_area_list";
        }
    }

    /**
     *插入一条新数据
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insertArea(String areaName,ModelMap modelMap){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaName(areaName);
        areaDTO.setFkCityId(SysConfig.BeforeConfig.PAGE_START);
        try {
            Boolean aBoolean = areaService.insertArea(areaDTO);
            if(aBoolean==true){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 删除一条新数据
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteArea(String id){
        try {
            Boolean aBoolean = areaService.deleteArea(Integer.parseInt(id));
            if(aBoolean==true){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/preUpdate")
    public String preUpdate(String id,ModelMap modelMap){
        try {
            AreaDTO areaDTO = areaService.queryAreaById(Integer.parseInt(id));
            modelMap.addAttribute("areaDTO",areaDTO);
            return "hou_area_update";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_main_page";
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateArea(String areaName,String id){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(Integer.parseInt(id));
        areaDTO.setAreaName(areaName);
        try {
            Boolean aBoolean = areaService.updateArea(areaDTO);
            if(aBoolean==true){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
