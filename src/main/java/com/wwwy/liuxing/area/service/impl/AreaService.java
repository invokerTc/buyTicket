package com.wwwy.liuxing.area.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.city.service.ICityService;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/11
 */
@Service
@Transactional
public class AreaService implements IAreaService {

    @Autowired
    private IAreaDAO areaDAO;


    private static final Logger logger = Logger.getLogger(AreaService.class);

    @Override
    public List<AreaDTO> queryAllArea(Integer cityId) throws Exception {
        return areaDAO.queryAll(cityId);
    }

    /**
     * 将地区对应的城市名当做key值，value值为将地区集合封装过后的PageInfo
     * @param cityId
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,PageInfo<AreaDTO>> queryAllArea(Integer cityId, Integer page)throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        Map<String, List<AreaDTO>> map = areaDAO.queryAllArea(cityId);
        String cityName =null;
        for (String key : map.keySet()) {
            cityName=key;
            if(null!=cityName){
                break;
            }
        }
        logger.debug("cityName====="+cityName);
        List<AreaDTO> areaDTOList = map.get(cityName);
//        将需要分页的集合进行封装
        List<AreaDTO> areaDTOList = areaDAO.queryAllArea(cityId);
        logger.info(areaDTOList);
        PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaDTOList);
        HashMap<String,PageInfo<AreaDTO>> hashMap = new HashMap<>();
        hashMap.put(cityName,pageInfo);
        logger.debug("pageInfo"+pageInfo);
        return hashMap;
    }

    @Override
    public AreaDTO queryAreaById(Integer areaId) throws Exception {
        return areaDAO.queryAreaById(areaId);
    }

    @Override
    public Boolean insertArea(AreaDTO areaDTO)throws Exception {
        return areaDAO.insertArea(areaDTO);
    }

    @Override
    public Boolean deleteArea(Integer areaId)throws Exception {
        return areaDAO.deleteArea(areaId);
    }

    @Override
    public Boolean updateArea(AreaDTO areaDTO)throws Exception {
        return areaDAO.updateArea(areaDTO);
    }

    @Override
    public Map<String,PageInfo<AreaDTO>> queryAreaByAny(String anyInfo,Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
        Map<String, List<AreaDTO>> map = areaDAO.queryAreaByAny(anyInfo);
        String cityName=null;
        HashMap<String,PageInfo<AreaDTO>> hashMap = new HashMap<>(SysConfig.BeforeConfig.MAP_SIZE);
        for (Map.Entry entry : map.entrySet()) {
            cityName= entry.getKey().toString();
            logger.debug("cityName====="+cityName);
            List<AreaDTO> areaDTOList= (List) entry.getValue();
            PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaDTOList);
            hashMap.put(cityName,pageInfo);
        }
        return hashMap;
    }

    @Override
    public Boolean deleteBatchAreas(int[] areaId) throws Exception {
        return areaDAO.deleteBatchAreas(areaId);
    }

    @Override
    public List<AreaDTO> queryAllArea(Integer cityId) throws Exception {
        List<AreaDTO> areaList = areaDAO.queryAllArea(cityId);
        return areaList;
    }
}
