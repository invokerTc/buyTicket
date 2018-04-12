package com.wwwy.liuxing.area.dao.impl;

import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/11
 */
@Repository
public class AreaDAO extends SqlSessionDaoSupport implements IAreaDAO {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public List<AreaDTO> queryAllArea() {
        List<AreaDTO> list = getSqlSession().selectList("com.wwwy.liuxin.area.dto.AreaMapper.queryAllArea");
        return list;
    }
}
