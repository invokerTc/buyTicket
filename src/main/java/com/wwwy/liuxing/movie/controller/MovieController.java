package com.wwwy.liuxing.movie.controller;

import com.github.pagehelper.PageInfo;
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
            modelMap.put("movieDTO",movieDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_one_movie_info";
    }

    /*
    *后台查询所有电影信息
    * */
    @RequestMapping("/list")
    public String getAllMovieInfo(Integer page, ModelMap modelMap){
        try {
            PageInfo<MovieDTO> allMovieInfo = movieService.getAllMovieInfo(page);
            List<MovieDTO>  movieDTOList = allMovieInfo.getList();
            modelMap.put("pageInfo",allMovieInfo);
            logger.info("========================"+allMovieInfo);
            modelMap.put("movieDTOList",movieDTOList);
            logger.info("============================"+movieDTOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_movielist";
    }

    /*
    * 后台增加一条电影信息
    * */
    @RequestMapping("/insert")
    public String insertMovieInfo(Integer page, MovieDTO movieDTO,ModelMap modelMap){
        try {
            boolean b = movieService.insertMovieInfo(movieDTO);
            if (b){
                PageInfo<MovieDTO> allMovieInfo = movieService.getAllMovieInfo(page);
                List<MovieDTO> list = allMovieInfo.getList();
                modelMap.addAttribute("pageInfo",allMovieInfo);
                logger.info("========================"+allMovieInfo);
                modelMap.addAttribute("movieDTOList",list);
                logger.info("============================"+list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_movielist";
    }


    @RequestMapping("/preupdate")
    public String preupdateMovieInfo(Integer movieId,ModelMap modelMap){
        try {
            MovieDTO movieDTO = movieService.getMovieInfoById(movieId);
            modelMap.addAttribute("movieDTO",movieDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pre_updete_movieinfo";
    }

    /*
    * 更改电影信息
    * */
    @RequestMapping("/update")
    public String updateMovieInfo(Integer page,MovieDTO movieDTO,ModelMap modelMap){
        try {
            boolean b = movieService.updateMovieInfo(movieDTO);
            if (b){
                PageInfo<MovieDTO> allMovieInfo = movieService.getAllMovieInfo(page);
                List<MovieDTO> movieDTOList = allMovieInfo.getList();
                modelMap.addAttribute("pageInfo",allMovieInfo);
                logger.info("====================="+allMovieInfo);
                modelMap.addAttribute("movieDTOList",movieDTOList);
                logger.info("========================="+movieDTOList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_movielist";
    }

    /*
    * 后台根据ID删除一条电影信息
    * */
    @RequestMapping("/delete")
    public String deleteMoiveInfo(Integer movieId,Integer page,ModelMap modelMap){
        try {
            boolean b = movieService.deleteMovieInfoById(movieId);
            if (b){
                PageInfo<MovieDTO> allMovieInfo = movieService.getAllMovieInfo(page);
                List<MovieDTO> allMovieInfoList = allMovieInfo.getList();
                modelMap.addAttribute("pageInfo",allMovieInfo);
                logger.info("======================"+allMovieInfo);
                modelMap.addAttribute("movieDTOList",allMovieInfoList);
                logger.info("======================"+allMovieInfoList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_movielist";
    }

    @RequestMapping("anyInfo")
    public String criteriaQueryMovie(String anyInfo,ModelMap modelMap,Integer page){
        try {
            PageInfo<MovieDTO> movieDTOPageInfo = movieService.criteriaQueryMovie(page, anyInfo);
            List<MovieDTO> movieDTOList = movieDTOPageInfo.getList();
            modelMap.addAttribute("pageInfo",movieDTOPageInfo);
            modelMap.addAttribute("movieDTOList",movieDTOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_movielist";
    }
}
