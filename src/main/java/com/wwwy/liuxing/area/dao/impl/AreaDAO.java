package com.wwwy.liuxing.area.dao.impl;

import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.system.SysConfig;
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
 * @date 2018/4/11
 */
@Repository
public class AreaDAO extends SqlSessionDaoSupport implements IAreaDAO {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public List<AreaDTO> queryAll(Integer cityId) throws Exception {
        List<AreaDTO> list = getSqlSession().selectList("com.wwwy.liuxin.area.dto.AreaMapper.queryAllArea",cityId);
        return list;
    }

    @Override
    public Map<String,List<AreaDTO>> queryAllArea(Integer cityId) throws Exception{
        List<AreaDTO> list = getSqlSession().selectList("com.wwwy.liuxin.area.dto.AreaMapper.queryAllArea",cityId);
        CityDTO cityDTO = list.get(SysConfig.BeforeConfig.ZERO_NUMBLE).getCityDTO();
        Map<String,List<AreaDTO>> map = new HashMap<>(SysConfig.BeforeConfig.MAP_SIZE);
        logger.debug("cityName"+cityDTO.getCityName());
        map.put(cityDTO.getCityName(),list);
        return map;
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

    @Override
    public Map<String,List<AreaDTO>> queryAreaByAny(String anyInfo) throws Exception {
        List<AreaDTO> list = getSqlSession().selectList("com.wwwy.liuxin.area.dto.AreaMapper.queryAny", anyInfo);
        CityDTO cityDTO = list.get(SysConfig.BeforeConfig.ZERO_NUMBLE).getCityDTO();
        Map<String,List<AreaDTO>> map = new HashMap<>(SysConfig.BeforeConfig.MAP_SIZE);
        logger.debug("cityName"+cityDTO.getCityName());
        map.put(cityDTO.getCityName(),list);
        return map;
    }

    @Override
    public Boolean deleteBatchAreas(int[] areaId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxin.area.dto.AreaMapper.batchDeleteAreas", areaId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }
}
