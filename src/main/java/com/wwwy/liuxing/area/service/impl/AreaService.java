package com.wwwy.liuxing.area.service.impl;

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
    public List<AreaDTO> queryAllArea(Integer currentPage)throws Exception {
        logger.debug("currentPage::::"+currentPage);
//        分页的初始位置
        int index=SysConfig.BeforeConfig.PAGE_START;
//        分页的大小
        int pageSize=SysConfig.BeforeConfig.PAGE_SIZE;
        if(currentPage< index){
            currentPage=index;
        }
        List<AreaDTO> areaDTOList = areaDAO.queryAllArea();
        int firstIndex=(currentPage-index)*pageSize;
        int lastIndex=currentPage*pageSize;
        logger.debug(areaDTOList.subList(firstIndex,lastIndex));
        return areaDTOList.subList(firstIndex,lastIndex);
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
}
