package com.wwwy.liuxing.hallmovie.dao;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;

import java.util.List;

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

    /**
     * 查询所有的影厅影片关联信息
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryAll()throws Exception;

    /**
     * 查询某个影厅放映某个电影的场次
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryPlayingHallMovie(Integer cityId,Integer theaterId,Integer movieId)throws Exception;
}
