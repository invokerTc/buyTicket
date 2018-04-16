package com.wwwy.liuxing.arth.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
public interface IAreaTheaterService {

    /**
     * 查询所有的地区管理影院信息，并分页
     * @param currentPage
     * @return
     * @throws Exception
     */
    PageInfo<AreaTheaterDTO> queryAll(Integer currentPage)throws Exception;
}
