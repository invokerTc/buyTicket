package com.wwwy.liuxing.hallmovie.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
@Service
public interface IHallMovieService {

    /**
     * 查询所有信息并分页
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<HallMovieDTO> queryAll(Integer page)throws Exception;

    /**
     * 插入一条新的信息
     * @return
     * @throws Exception
     */
    Boolean insert(HallMovieDTO hallMovieDTO)throws Exception;
}
