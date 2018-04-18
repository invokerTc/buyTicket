package com.wwwy.liuxing.hallmovie.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
@Controller
@RequestMapping("/hallMovie")
public class HallMovieController {


    private static final Logger logger = Logger.getLogger(HallMovieController.class);

    @Autowired
    private IHallMovieService hallMovieService;


    @RequestMapping("/all")
    public String queryAll(HttpServletRequest request, ModelMap modelMap){
        String page = request.getParameter("page");
        try {
            PageInfo<HallMovieDTO> pageInfo = hallMovieService.queryAll(Integer.parseInt(page));
            List<HallMovieDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("hallMovieList",list);
            return "hou_hall_movie_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String isnert(HttpServletRequest request){
        String hallId = request.getParameter("hallId");
        String movieId = request.getParameter("movieId");
        String movieRuntime = request.getParameter("movieRuntime");
        String moviePrice = request.getParameter("moviePrice");
        String movieVersion = request.getParameter("movieVersion");
        HallMovieDTO hallMovieDTO = new HallMovieDTO();
        hallMovieDTO.setFkHallId(Integer.parseInt(hallId));
        hallMovieDTO.setFkMovieId(Integer.parseInt(movieId));
        hallMovieDTO.setMovieRuntime(movieRuntime);
        hallMovieDTO.setMoviePrice(Integer.parseInt(moviePrice));
        hallMovieDTO.setMovieVersion(movieVersion);
        try {
            Boolean insert = hallMovieService.insert(hallMovieDTO);
            if(insert){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
