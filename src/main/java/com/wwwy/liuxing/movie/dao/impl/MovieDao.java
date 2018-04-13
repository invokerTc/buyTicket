package com.wwwy.liuxing.movie.dao.impl;

import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影相关的dao层实体类
 */
@Repository
public class MovieDao extends SqlSessionDaoSupport implements IMovieDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     *
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityName", cityName);
        List<MovieDTO> movieList = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.queryAllMovieByCityName", map);
        return movieList;
    }

    /**
     * 根据传入的条件动态查询符合的一个或多个条件的电影集合
     *
     * @param type    影片类型
     * @param country 影片国家
     * @param date    影片上映时间
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getMoviesByCondition(String type, String country, String date) throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieDate(date);
        movieDTO.setMovieCountry(country);
        movieDTO.setMovieType(type);
        List<MovieDTO> list = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.selectMovieByCondition", movieDTO);
        return list;
    }
}
