package com.wwwy.liuxing.theater.dao.impl;

import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterDAO extends SqlSessionDaoSupport implements ITheaterDAO {
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
}

