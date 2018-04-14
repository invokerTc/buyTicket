package com.wwwy.liuxing.theater.service.impl;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private ITheaterDAO theaterDAO;
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
