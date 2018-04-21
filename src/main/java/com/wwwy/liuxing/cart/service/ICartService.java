package com.wwwy.liuxing.cart.service;

import com.wwwy.liuxing.cart.dto.CartDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public interface ICartService {
    void saveBookingCart(String tele, CartDTO cartDTO);
    CartDTO getBookingCart(String tele,String movieName);
    List<String> getSetList(String selectedSets);
    /**
     * 保存选定的座位 场次 价格等观影详细信息
     *
     * @param tele
     * @param cartDTO
     * @return
     * @throws Exception
     */
    String saveCartDetail(String tele, CartDTO cartDTO) throws Exception;

    /**
     * 获取订购的电影票信息
     *
     * @param tele
     * @param hallName
     * @param watchingTime
     * @return
     * @throws Exception
     */
    CartDTO getCartDetail(String tele, String hallName, String watchingTime) throws Exception;

    /**
     * 获取具体的座位信息
     *
     * @param selectedSets
     * @return
     * @throws Exception
     */
    List<String> getSetList(String selectedSets) throws Exception;

    /**
     * 用hallMovieId以及作为名称，保存到redis,保证并发时被选座位的唯一。
     * @param tele
     * @param hallMovieId
     * @param value
     * @return
     */
    String conmmitOrder(String tele, String hallMovieId, String value);
}
