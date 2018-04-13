package com.wwwy.liuxing.area.dao.impl;

import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.system.SysConfig;
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
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public List<AreaDTO> queryAllArea() throws Exception{
        List<AreaDTO> list = getSqlSession().selectList("com.wwwy.liuxin.area.dto.AreaMapper.queryAllArea");
        return list;
    }

    @Override
    public AreaDTO queryAreaById(Integer areaId) throws Exception {
        AreaDTO area = getSqlSession().selectOne("com.wwwy.liuxin.area.dto.AreaMapper.queryAreaById", areaId);
        return area;
    }

    @Override
    public Boolean insertArea(AreaDTO areaDTO)throws Exception {
        int insert = getSqlSession().insert("com.wwwy.liuxin.area.dto.AreaMapper.insertArea", areaDTO);
        return insert< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean deleteArea(Integer areaId)throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxin.area.dto.AreaMapper.deleteArea", areaId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean updateArea(AreaDTO areaDTO)throws Exception {
        int update = getSqlSession().update("com.wwwy.liuxin.area.dto.AreaMapper.updateArea", areaDTO);
        return update< SysConfig.BeforeConfig.PAGE_START?false:true;
    }
}
