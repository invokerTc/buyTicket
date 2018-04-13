package com.wwwy.liuxing.movie.service.impl;

import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有感的service的实体类
 */
@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieDao movieDao;


    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception {
        List<MovieDTO> movieDTOList = movieDao.getAllMovieByCityName(cityName);
        return movieDTOList;
    }
}
