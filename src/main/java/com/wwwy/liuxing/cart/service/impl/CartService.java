package com.wwwy.liuxing.cart.service.impl;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import com.wwwy.liuxing.message.httpApiDemo.common.Config;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/4/17.
 */
@Service
public class CartService implements ICartService {
    private Logger logger = Logger.getLogger(CartService.class);
    @Autowired
    private IMovieCache movieCache;

    @Override
    public String saveCartDetail(String tele, CartDTO cartDTO) throws Exception {
        String seats = cartDTO.getSelectedSets();
        List<String> setList = getSetList(seats);
        String key = SysConfig.BeforeConfig.PREFIX_BOOKING + tele;
        ArrayList<String> paramList = new ArrayList<String>(20);
        paramList.add(cartDTO.getMovieName());
        paramList.add(cartDTO.getWatchingTime());
        paramList.add(cartDTO.getCinemaName());
        paramList.add(cartDTO.getHallName());
        paramList.add(cartDTO.getSelectedSets());
        paramList.add(cartDTO.getTotalPrice() + "");
        movieCache.saveList(key, paramList);
        return "save detail success";
    }

    @Override
    public CartDTO getCartDetail(String tele, String hallName, String watchingTime) throws Exception {
        CartDTO cartDTO = new CartDTO();
        String key = SysConfig.BeforeConfig.PREFIX_BOOKING + hallName + watchingTime + tele;
        List<String> resultList = movieCache.getAllByKey(key);
        cartDTO.setMovieName(resultList.get(0));
        cartDTO.setWatchingTime(resultList.get(1));
        cartDTO.setCinemaName(resultList.get(2));
        cartDTO.setHallName(resultList.get(3));
        cartDTO.setSelectedSets(resultList.get(4));
        cartDTO.setTotalPrice(Integer.parseInt(resultList.get(5)));
        return cartDTO;
    }

    @Override
    public List<String> getSetList(String selectedSets) {
        String[] split = selectedSets.split(",");
        List<String> arrayList = Arrays.asList(split);
        return arrayList;
    }

    @Override
    public String conmmitOrder(String tele, String hallMovieId, String value) {
        String result = "";
        List<String> setList = getSetList(value);
        String backResult = movieCache.saveString(setList, hallMovieId, tele);
        if (backResult.equals("")) {
            result = "success";
            logger.info(tele + "============订座成功");
        } else {
            result = backResult;
            logger.info(tele + "=========选座失败"+"=========="+result + "==========已被预订");
        }
        return result;
    }
}
