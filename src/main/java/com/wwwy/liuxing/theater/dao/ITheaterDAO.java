package com.wwwy.liuxing.theater.dao;

import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ITheaterDAO {
    List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception;
}
