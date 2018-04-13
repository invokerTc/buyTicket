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
    List<AreaDTO> queryAllArea(Integer cityId)throws Exception;

    /**
     * 根据id查询某一个地区的信息
     * @param areaId
     * @return
     * @throws Exception
     */
    AreaDTO queryAreaById(Integer areaId)throws Exception;

    /**
     * 插入新的地区
     * @param areaDTO
     * @return
     */
    Boolean insertArea(AreaDTO areaDTO)throws Exception;

    /**
     * 根据地区id删除对应的地区
     * @param areaId
     * @return
     */
    Boolean deleteArea(Integer areaId)throws Exception;

    /**
     * 根据地区id修改对应地区的信息
     * @param areaDTO
     * @return
     */
    Boolean updateArea(AreaDTO areaDTO)throws Exception;

    /**
     * 根据任何信息查找地区信息
     * @return
     * @throws Exception
     */
    List<AreaDTO> queryAreaByAny(String anyInfo)throws Exception;
}
