package com.wwwy.liuxing.cart.controller;

import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("/showBooking")
    public String showBooking(String tele, String movieName, Model model){
        CartDTO cartDTO = cartService.getBookingCart(tele, movieName);
        String selectedSets = cartDTO.getSelectedSets();
        List<String> setList = cartService.getSetList(selectedSets);
        model.addAttribute("cart",cartDTO);
        model.addAttribute("setList",setList);
        return "waiting_for_pay";
    public String showCartDetail(String tele, String hallName, String watchingTime, Model model) {
        CartDTO cartDTO = null;
        try {
            cartDTO = cartService.getCartDetail(tele, hallName, watchingTime);
            String selectedSets = cartDTO.getSelectedSets();
            List<String> setList = cartService.getSetList(selectedSets);
            model.addAttribute("cart", cartDTO);
            model.addAttribute("setList", setList);
            return "waiting_for_pay";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error404";
    }

    @RequestMapping(value = "/conmmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String conmmit(String telephone, CartDTO cart, String hallMovieId, String selectedSets) {
        String result = cartService.conmmitOrder(telephone, hallMovieId, selectedSets);
        try {
            if (result.equals("success")) {
                CartDTO cartDTO = new CartDTO();
                cartDTO.setSelectedSets(selectedSets);
                cartDTO.setTotalPrice(cart.getTotalPrice());
                cartDTO.setCinemaName(cart.getCinemaName());
                cartDTO.setMovieName(cart.getMovieName());
                cartDTO.setWatchingTime(cart.getWatchingTime());
                cartDTO.setHallName(cart.getHallName());
                cartService.saveCartDetail(telephone, cartDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
