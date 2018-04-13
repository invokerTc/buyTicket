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
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityName",cityName);
        List<MovieDTO> movieList = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.queryAllMovieByCityName", map);
        return movieList;
    }

    /**
     * 根据城市ID和电影ID获得一个电影信息
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public MovieDTO getMovieByCityIdAndMovieId(Integer cityId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("movieId",movieId);
        MovieDTO movie = getSqlSession().selectOne("com.wwwy.liuxing.movie.dto.MovieMapper.getOneMovieByCityIdAnDMovieId", map);
        return movie;
    }


}
