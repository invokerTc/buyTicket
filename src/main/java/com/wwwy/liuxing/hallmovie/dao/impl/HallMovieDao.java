package com.wwwy.liuxing.hallmovie.dao.impl;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by wanghao on 2018/4/14.
 */
@Repository
public class HallMovieDao extends SqlSessionDaoSupport implements IHallMovieDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public HallMovieDTO getLowestMoviePrice(Integer cityId, Integer theaterId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("theaterId",theaterId);
        map.put("movieId",movieId);
        HallMovieDTO hallMovieDTO = getSqlSession().selectOne("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryLowestMoviePriceList", map);
        return hallMovieDTO;
    }

}
