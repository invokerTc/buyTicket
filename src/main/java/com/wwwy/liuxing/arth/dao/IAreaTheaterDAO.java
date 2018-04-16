package com.wwwy.liuxing.arth.dao;

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
public interface IAreaTheaterDAO {

    /**
     * 查询所有的地区和影院关联的记录并分页
     * @return
     * @throws Exception
     */
    List<AreaTheaterDTO> queryAllArea()throws Exception;
}
