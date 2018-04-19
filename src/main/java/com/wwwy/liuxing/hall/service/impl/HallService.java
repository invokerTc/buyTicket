package com.wwwy.liuxing.hall.service.impl;

import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghao on 2018/4/12.
 */
@Service
public class HallService implements IHallService {
    @Autowired
    private IHallDao hallDao;

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
    public HallDTO queryByName(String name) throws Exception {
        return hallDao.queryByName(name);
    }
}
