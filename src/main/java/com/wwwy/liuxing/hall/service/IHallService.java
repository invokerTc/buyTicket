package com.wwwy.liuxing.hall.service;

import com.wwwy.liuxing.hall.dto.HallDTO;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的service层
 */
public interface IHallService  {
    HallDTO queryHallByTheaterIdAndHallId(String theaterId, String hallId) throws Exception;

    /**
     * 根据影厅名称查询影厅的座位
     * @param name
     * @return
     */
    HallDTO queryByName(String name) throws Exception;
}
