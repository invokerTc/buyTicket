package com.wwwy.liuxing.movie.dao;

import com.wwwy.liuxing.movie.dto.MovieDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的dao层接口类
 */
@Repository
public interface IMovieDao  {
    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     * @param cityName
     * @return
     * @throws Exception
     */
    List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception;

    /**
     * 根据城市ID和电影ID获得一个电影信息
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    MovieDTO getMovieByCityIdAndMovieId(Integer cityId,Integer movieId) throws Exception;
}
