package com.wwwy.liuxing.theater.service;

import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ITheaterService {
    List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception;
}
