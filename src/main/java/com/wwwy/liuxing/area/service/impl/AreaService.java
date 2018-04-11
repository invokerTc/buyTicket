package com.wwwy.liuxing.area.service.impl;

import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/11
 */
@Service
@Transactional
public class AreaService implements IAreaService {

    @Autowired
    private IAreaDAO areaDAO;


    @Override
    public List<AreaDTO> queryAllArea() {
        return areaDAO.queryAllArea();
    }
}
