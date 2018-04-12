package com.wwwy.liuxing.theater.service.impl;

import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private ITheaterDAO theaterDAO;
    @Override
    public List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception {
        return theaterDAO.queryTheaterByPattern(pattern);
    }
}
