package com.wwwy.liuxing.hall.dao.impl;

import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的dao层
 */
@Repository
public class HallDao extends SqlSessionDaoSupport implements IHallDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据影院id和影厅id获取影厅详细信息（座位信息）
     * @param theaterId
     * @param hallId
     * @return
     */
    @Override
    public HallDTO queryHallByTheaterIdAndHallId(Integer theaterId, Integer hallId) throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("theaterId",1);
        map.put("hallId",1);
        HallDTO hall = getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.queryHallInfoByHallId", map);
        return hall;
    }

    @Override
    public HallDTO queryByName(String name) throws Exception {
        HallDTO hallDTO = getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.queryExistPosition", name);
        return hallDTO;
    }
}
