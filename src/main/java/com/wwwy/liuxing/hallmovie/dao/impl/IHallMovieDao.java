package com.wwwy.liuxing.hallmovie.dao.impl;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;

/**
 * Created by wanghao on 2018/4/14.
 * 与影厅电影有关的dao接口类
 */
public interface IHallMovieDao {
    /**
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    HallMovieDTO getLowestMoviePrice(Integer cityId,Integer theaterId,Integer movieId)throws Exception;
}
