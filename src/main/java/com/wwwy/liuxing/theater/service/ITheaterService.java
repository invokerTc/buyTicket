package com.wwwy.liuxing.theater.service;

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
}
