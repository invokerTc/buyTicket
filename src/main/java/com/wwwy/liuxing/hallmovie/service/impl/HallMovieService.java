package com.wwwy.liuxing.hallmovie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
@Service
public class HallMovieService implements IHallMovieService {
    
    @Autowired
    private IHallMovieDao hallMovieDao;

    @Autowired
    private IMovieDao movieDAO;

    @Autowired
    private IHallDao hallDAO;
    
    @Override
    public PageInfo<HallMovieDTO> queryAll(Integer page) throws Exception {
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallMovieDTO> list = hallMovieDao.queryAll();
        for (HallMovieDTO hm :
                list) {
            
        }
        PageInfo<HallMovieDTO> pageInfo = new PageInfo<HallMovieDTO>(list);
        return pageInfo;
    }

    /**
     * 查询某个影厅放映某个电影的场次
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<HallMovieDTO> queryPlayingHallMovie(String cityId, String theaterId, String movieId) throws Exception {
        int cityid = Integer.parseInt(cityId);
        int theaterid = Integer.parseInt(theaterId);
        int movieid = Integer.parseInt(movieId);
        List<HallMovieDTO> list = hallMovieDao.queryPlayingHallMovie(cityid, theaterid, movieid);
        return list;
    }
}
