package com.wwwy.liuxing.redis.test;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.message.util.RandomNumUtil;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import com.wwwy.liuxing.utils.RedisUtil;
import com.wwwy.liuxing.utils.SerializationUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class RedisTest {
    private Logger logger= Logger.getLogger(RedisTest.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RandomNumUtil randomNumUtil;
    @Autowired
    private IMovieCache movieCache;
    @Autowired
    private IMovieService movieService;
    @Test
    public void testCase1(){
        stringRedisTemplate.opsForValue().set("username","xiaoming",1, TimeUnit.MINUTES);
    }
    @Test
    public void testCase2(){
        String rand = randomNumUtil.setRand("1243");
        logger.info(rand);
        movieCache.getValue("1243");
    }


    @Test
    public void testRedisMovie(){
        Jedis jedis = new Jedis("192.168.71.117");
        ArrayList<MovieDTO> movieList = new ArrayList<>();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieName("头号玩家");
        movieDTO.setMovieCountry("美国");
        MovieDTO movieDTO1 = new MovieDTO();
        movieDTO1.setMovieName("幽灵战场");
        movieDTO1.setMovieCountry("英国");
        movieList.add(movieDTO);
        movieList.add(movieDTO1);
        jedis.set("movieList".getBytes(), SerializationUtil.serialize(movieList));


        Jedis jedis2 = new Jedis("192.168.71.117");
        byte[] bs = jedis2.get("movieList".getBytes());
        List<MovieDTO> movieDTOList = (List<MovieDTO>) SerializationUtil.deserialize(bs);
//        logger.info(movie.getMovieName()+"\t"+movie.getMovieCountry());
        for (MovieDTO movie:movieDTOList) {
            logger.info(movie.getMovieName()+"\t"+movie.getMovieCountry());
        }
    }

    /**
     * 测试通过缓存获取首页电影信息
     */
    @Test
    public void testMovieRedis(){
        try {
            Boolean result = RedisUtil.getRedis().exists("testMovieList".getBytes());
            //如果存在就从redis中查取，不存在就从数据库查
            if(result){
                logger.info("redis中存在testMovieList这个key，从redis中获取");

                byte[] bytes = RedisUtil.getRedis().get("testMovieList".getBytes());
                List<MovieDTO> movieDTOList1 = (List<MovieDTO>) SerializationUtil.deserialize(bytes);
                for (MovieDTO movie :movieDTOList1) {
                    logger.info(movie.getMovieId()+"\t"+movie.getMovieName()+"\t"+movie.getMovieScore());
                }
            }else {
                logger.info("redis中不存在testMovieList这个key，从数据库查询所需数据，放入缓存，");
                List<MovieDTO> movieDTOList1 = movieService.getAllMovieByCityName("武汉");
                RedisUtil.getRedis().set("testMovieList".getBytes(),SerializationUtil.serialize(movieDTOList1));
                RedisUtil.getRedis().expire("testMovieList".getBytes(),10);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
