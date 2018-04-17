package com.wwwy.liuxing.area.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public PageInfo<AreaDTO> queryAllArea(Integer cityId,Integer page)throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }

        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaDTO> areaDTOList = areaDAO.queryAllArea(cityId);
        PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaDTOList);
        logger.debug("pageInfo"+pageInfo);
        return pageInfo;
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
    public PageInfo<AreaDTO> queryAreaByAny(String anyInfo,Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }

        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaDTO> areaDTOList = areaDAO.queryAreaByAny(anyInfo);
        PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaDTOList);
        logger.debug("pageInfo"+pageInfo);
        return pageInfo;
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
