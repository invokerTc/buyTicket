package com.wwwy.liuxing.hall.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的service层
 */
public interface IHallService  {

    HallDTO queryHallByTheaterIdAndHallId(String theaterId, String hallId) throws Exception;

    /**
     * 查询出所有的影厅并分页
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<HallDTO> queryAllHall(Integer page)throws Exception;

    /**
     * 插入一条影厅记录
     * @param hallDTO
     * @return
     * @throws Exception
     */
    Boolean insertHall(HallDTO hallDTO)throws Exception;

    /**
     * 很久id删除一条记录
     * @param hallId
     * @return
     * @throws Exception
     */
    Boolean deleteHall(Integer hallId)throws Exception;
}
