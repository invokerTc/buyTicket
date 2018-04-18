package com.wwwy.liuxing.theater.dao.impl;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TheaterDAO extends SqlSessionDaoSupport implements ITheaterDAO {

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 依照传入的pattern查询与之匹配的影院
     * @param pattern
     * @return
     */
    @Override
    public List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception {
        List<TheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryByPattern", pattern);
        return list;
    }

    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<TheaterDTO> queryLowestPriceTheaterList(Integer cityId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("movieId",movieId);
        List<TheaterDTO> theaterList = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryLowestPriceTheaterList", map);
        return theaterList;
    }

    @Override
    public List<TheaterDTO> queryAllTheater(Integer areaId) throws Exception {
        List<TheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryAllTheater", areaId);
        return list;
    }

    @Override
    public TheaterDTO queryTheaterById(Integer theaterId) throws Exception {
        return null;
    }

    @Override
    public Boolean insertTheater(TheaterDTO theaterDTO) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteTheater(Integer theaterId) throws Exception {
        return null;
    }

    @Override
    public Boolean updateTheater(TheaterDTO theaterDTO) throws Exception {
        return null;
    }

    @Override
    public List<AreaDTO> queryTheaterByAny(String anyInfo) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteBatchTheater(int[] TheaterId) throws Exception {
        return null;
    }
}

