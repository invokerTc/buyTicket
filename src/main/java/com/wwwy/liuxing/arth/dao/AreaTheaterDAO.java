package com.wwwy.liuxing.arth.dao;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
@Repository
public class AreaTheaterDAO extends SqlSessionDaoSupport implements IAreaTheaterDAO {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }



    @Override
    public List<AreaTheaterDTO> queryAllArea() throws Exception {
        List<AreaTheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.queryAll");
        return list;
    }
}
