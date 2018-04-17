package com.wwwy.liuxing.movie.controller;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ITheaterService theaterService;
    @Autowired
    private IAreaService areaService;

    /**
     * 首页获取所有的电影列表
     * @param cityName
     * @param modelMap
     * @return
     */
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

    /**
     * 点击首页一个电影获取该电影的信息
     * @param cityId
     * @param movieId
     * @param modelMap
     * @return
     */
    @RequestMapping("/getOneMovieInfo")
    public String getOneMovieById(String cityId,String movieId,ModelMap modelMap){
        logger.info("进入MovieController 的 /movie/getOneMovieInfo  方法");
        try {
            MovieDTO movieDTO = movieService.getMovieByCityIdAndMovieId(cityId, movieId);
            List<TheaterDTO> theaterList = theaterService.queryLowestPriceTheater(cityId, movieId);
            List<AreaDTO> areaList = areaService.queryAllArea(Integer.parseInt(cityId));
            modelMap.put("movieDTO",movieDTO);
            modelMap.put("theaterList",theaterList);
            modelMap.put("areaList",areaList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_movie_cinemas_price";
    }
}
