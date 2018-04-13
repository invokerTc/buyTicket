package com.wwwy.liuxing.movie.test;

import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class MovieTest {
    private static final Logger logger = Logger.getLogger(MovieTest.class);
    @Autowired
    private IMovieDao movieDao;

    @Autowired
    private IMovieService movieService;

    /**
     * 测试MovieDao的  getAllMovieByCityName(String cityName)
     */
    @Test
    public void testDaoGetAllMovieByCityName(){
        try {
            List<MovieDTO> dtoList = movieDao.getAllMovieByCityName("武汉");
            for (MovieDTO movie :dtoList) {
                logger.info(movie.getMovieName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试MovieService的  getAllMovieByCityName(String cityName)
     */
    @Test
    public void testServiceGetAllMovieByCityName(){
        try {
            List<MovieDTO> movieDTOList = movieService.getAllMovieByCityName("武汉");
            for (MovieDTO movie:movieDTOList) {
                logger.info(movie.getMovieId()+"\t"+movie.getMovieName()+"\t"+movie.getMovieScore()+"\t"+movie.getMovieImg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetMovieByCondition(){
        try {
            List<MovieDTO> movieDTOs = movieDao.getMoviesByCondition("动作,科幻,冒险", "美国", "2018-03-30");
            for (MovieDTO movie:movieDTOs) {
                if (logger.isDebugEnabled()){
                    logger.debug(movie.getMovieName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}