package com.wwwy.liuxing.theater.service;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ITheaterService {
    List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception;
    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryLowestPriceTheaterList(String cityId,String movieId) throws Exception;

    /**
     * 查询所有的影院，返回一个list集合
     * @param theaterId
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryAllTheater(Integer areaId)throws Exception;

    /**
     * 根据id查询某一个影院的信息
     * @param theaterId
     * @return
     * @throws Exception
     */
    TheaterDTO queryTheaterById(Integer theaterId)throws Exception;

    /**
     * 插入新的影院
     * @param theaterDTO
     * @return
     * @throws Exception
     */
    Boolean insertTheater(TheaterDTO theaterDTO)throws Exception;

    /**
     * 根据id删除对应的影院信息
     * @param theaterId
     * @return
     * @throws Exception
     */
    Boolean deleteTheater(Integer theaterId)throws Exception;

    /**
     * 修改对应的影院信息
     * @param theaterDTO
     * @return
     * @throws Exception
     */
    Boolean updateTheater(TheaterDTO theaterDTO)throws Exception;

    /**
     * 根据任意的信息查询
     * @param anyInfo
     * @return
     * @throws Exception
     */
    List<AreaDTO> queryTheaterByAny(String anyInfo)throws Exception;

    /**
     * 批量删除影院信息
     * @param TheaterId
     * @return
     * @throws Exception
     */
    Boolean deleteBatchTheater(int[] TheaterId)throws Exception;
}
