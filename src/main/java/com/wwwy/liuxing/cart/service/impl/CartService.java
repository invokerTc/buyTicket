package com.wwwy.liuxing.cart.service.impl;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2018/4/17.
 */
@Service
public class CartService implements ICartService {
    @Autowired
    private IMovieCache movieCache;

    @Override
    public String saveBookingCart(String tele, CartDTO cartDTO) {
        String pattern = SysConfig.BeforeConfig.PREFIX_BOOKING + cartDTO.getHallName() + cartDTO.getWatchingTime() + "*";
        Set<String> bookingSeat = getBookingSeat(pattern);
        String seats = cartDTO.getSelectedSets();
        List<String> setList = getSetList(seats);
        String contain = isContain(setList, bookingSeat);
        if (contain.equals("")) {
            String key = SysConfig.BeforeConfig.PREFIX_BOOKING + cartDTO.getHallName() + cartDTO.getWatchingTime() + tele;
            ArrayList<String> paramList = new ArrayList<String>(20);
            paramList.add(cartDTO.getMovieName());
            paramList.add(cartDTO.getWatchingTime());
            paramList.add(cartDTO.getCinemaName());
            paramList.add(cartDTO.getHallName());
            paramList.add(cartDTO.getSelectedSets());
            paramList.add(cartDTO.getTotalPrice() + "");
            movieCache.saveList(key, paramList);
            return contain;
        }
        contain = contain.substring(0, contain.length() - 1);
        return contain;
    }

    @Override
    public CartDTO getBookingCart(String tele, String hallName, String watchingTime) {
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

    /**
     * 获取redis中已经存在的座位集合
     *
     * @param pattern
     * @return
     */
    @Override
    public Set<String> getBookingSeat(String pattern) {
        Set<String> keys = movieCache.getAllKeyLikePattern(pattern);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : keys) {
            stringBuilder.append(movieCache.getAllByKey(str).get(4));
            stringBuilder.append(",");
        }
        List<String> setList = getSetList(stringBuilder.toString());
        HashSet<String> hashSet = new HashSet<>(setList);
        return hashSet;
    }

    public String isContain(List<String> listToCheck, Set<String> SetModel) {
        String repeatSeat = "";
        for (String str : listToCheck) {
            if (SetModel.contains(str)) {
                repeatSeat += str + ",";
            }
        }
        return repeatSeat;
    }
}
