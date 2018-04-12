package com.wwwy.liuxing.hall.dao;

import com.wwwy.liuxing.hall.dto.HallDTO;

/**
 * Created by wanghao on 2018/4/12.
 * 获取影厅的详细信息
 */
public interface IHallDao {
    /**
     * 根据影院id和影厅ID获取影厅详细信息
     * @param theaterId
     * @param hallId
     * @return
     */
    HallDTO queryHallByTheaterIdAndHallId(Integer theaterId,Integer hallId) throws Exception;
}
