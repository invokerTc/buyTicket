package com.wwwy.liuxing.movie.controller;

import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的controller层
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    private static final Logger logger = Logger.getLogger(MovieController.class);

    @Autowired
    private IMovieService movieService;

    @RequestMapping("getAllMovie")
    public String getAllMovieByCityName(String cityName, ModelMap modelMap){
        logger.info("进入MovieController 的 /movie/getAllMovie  方法");
        try {
            List<MovieDTO> movieList = movieService.getAllMovieByCityName(cityName);
            modelMap.put("movieList",movieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_films_list";
    }
    @RequestMapping("/getOneMovieInfo")
    public String getOneMovieById(String cityId,String movieId,ModelMap modelMap){
        logger.info("进入MovieController 的 /movie/getOneMovieInfo  方法");
        try {
            MovieDTO movieDTO = movieService.getMovieByCityIdAndMovieId(cityId, movieId);
            modelMap.put("movieDTO",movieDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_one_movie_info";
    }
}
