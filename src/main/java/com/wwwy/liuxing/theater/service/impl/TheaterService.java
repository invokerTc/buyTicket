package com.wwwy.liuxing.theater.service.impl;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.dto.dao.IHallMovieDao;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12.
 */
@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private ITheaterDAO theaterDAO;
    @Autowired
    private IHallMovieDao hallMovieDao;
    @Override
    public List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception {
        return theaterDAO.queryTheaterByPattern(pattern);
    }
    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<TheaterDTO> queryLowestPriceTheaterList(String cityId, String movieId) throws Exception {
        int cityid = Integer.parseInt(cityId);
        int movieid = Integer.parseInt(movieId);
        List<TheaterDTO> theaterDTOList = theaterDAO.queryLowestPriceTheaterList(cityid, movieid);
        return theaterDTOList;
    }

    /**
     * 根据城市和电影获取放映该电影的电影院名、影院地址、最低价格
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    public Map<TheaterDTO,HallMovieDTO> queryLowestTheaterAndPrice(String cityId,String movieId)throws Exception{
        HashMap<TheaterDTO, HallMovieDTO> map = new HashMap<>();
        List<TheaterDTO> theaterList = queryLowestPriceTheaterList(cityId, movieId);
        for(TheaterDTO theater:theaterList){
            HallMovieDTO hallMovieDTO = hallMovieDao.getLowestMoviePrice(Integer.parseInt(cityId), theater.getTheaterId(), Integer.parseInt(movieId));
            map.put(theater,hallMovieDTO);
        }
        return map;
    }

    /**
     * 根据城市和电影获取放映该电影的电影院名、影院地址、最低价格(必须每次实时从数据库刷新数据，不能放缓存也不能取缓存)
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<TheaterDTO> queryLowestPriceTheater(String cityId, String movieId) throws Exception {
        int cityid = Integer.parseInt(cityId);
        int movieid = Integer.parseInt(movieId);
        List<TheaterDTO> theaterList = theaterDAO.queryLowestPriceTheaterList(cityid, movieid);
        for (TheaterDTO theater:theaterList) {
            HallMovieDTO hallMovieDTO = hallMovieDao.getLowestMoviePrice(Integer.parseInt(cityId), theater.getTheaterId(), Integer.parseInt(movieId));
            theater.setLowestPrice(hallMovieDTO.getMoviePrice());
        }
        return theaterList;
    }

    /**
     * 根据城市和电影获取放映该电影的最低价格
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    public List<HallMovieDTO> queryLowestPrice(String cityId,String movieId) throws Exception{
        ArrayList<HallMovieDTO> hallMovieList = new ArrayList<>(10);
        List<TheaterDTO> theaterList = queryLowestPriceTheater(cityId, movieId);
        for (TheaterDTO theater:theaterList) {
            HallMovieDTO hallMovieDTO = hallMovieDao.getLowestMoviePrice(Integer.parseInt(cityId), theater.getTheaterId(), Integer.parseInt(movieId));
            hallMovieList.add(hallMovieDTO);
        }
        return hallMovieList;
    }


    @Override
    public List<TheaterDTO> queryAllTheater(Integer areaId) throws Exception {
        return theaterDAO.queryAllTheater(areaId);
    }

    @Override
    public TheaterDTO queryTheaterById(Integer theaterId) throws Exception {
        return null;
    }

    @Override
    public Boolean insertTheater(TheaterDTO theaterDTO) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteTheater(Integer theaterId) throws Exception {
        return null;
    }

    @Override
    public Boolean updateTheater(TheaterDTO theaterDTO) throws Exception {
        return null;
    }

    @Override
    public List<AreaDTO> queryTheaterByAny(String anyInfo) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteBatchTheater(int[] TheaterId) throws Exception {
        return null;
    }
}
