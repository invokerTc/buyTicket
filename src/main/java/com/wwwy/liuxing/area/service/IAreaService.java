package com.wwwy.liuxing.area.service;

import com.wwwy.liuxing.area.dto.AreaDTO;

import java.util.List;

/**
 *地区的增删查改service接口
 * @author W1665
 * @date 2018/4/11
 */
public interface IAreaService {

    /**
     * 查询所有的地区，返回一个list集合
     * @return
     */
    List<AreaDTO> queryAllArea();
}
