package com.wwwy.liuxing.area.dao;

import com.wwwy.liuxing.area.dto.AreaDTO;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/11
 */
public interface IAreaDAO {

    /**
     * 查询所有的地区，返回一个list集合
     * @return
     */
    List<AreaDTO> queryAllArea();

}
