package com.wwwy.liuxing.cart.service;

import com.wwwy.liuxing.cart.dto.CartDTO;
import org.apache.shiro.web.tags.SecureTag;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/17.
 */

public interface ICartService {
    String saveBookingCart(String tele, CartDTO cartDTO);
    CartDTO getBookingCart(String tele, String hallName,String watchingTime);
    List<String> getSetList(String selectedSets);
    Set<String> getBookingSeat(String pattern);
}
