package com.wwwy.liuxing.hall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.service.IHallService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 */
@Service
public class HallService implements IHallService {
    @Autowired
    private IHallDao hallDao;

    private static final Logger logger = Logger.getLogger(HallService.class);

    /**
     * 根据影院id和影厅id获取影厅详细信息（座位信息）
     * @param theaterId
     * @param hallId
     * @return
     * @throws Exception
     */
    @Override
    public HallDTO queryHallByTheaterIdAndHallId(String theaterId, String hallId) throws Exception {
        int theaterid = Integer.parseInt(theaterId);
        int hallid = Integer.parseInt(hallId);
        HallDTO hallDTO = hallDao.queryHallByTheaterIdAndHallId(theaterid, hallid);
        return hallDTO;
    }

    @Override
    public PageInfo<HallDTO> queryAllHall(Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallDTO> list = hallDao.queryAllHall();
        PageInfo<HallDTO> pageInfo = new PageInfo<HallDTO>(list);
        return pageInfo;
    }

    @Override
    public HallDTO queryHallById(Integer id) throws Exception {
        return hallDao.queryHallById(id);
    }

    @Override
    public Boolean insertHall(HallDTO hallDTO) throws Exception {
        return hallDao.insertHall(hallDTO);
    }

    @Override
    public Boolean deleteHall(Integer hallId) throws Exception {
        return null;
    }
}
