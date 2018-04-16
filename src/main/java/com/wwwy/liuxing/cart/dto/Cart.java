package com.wwwy.liuxing.cart.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/16.
 */
public class Cart implements Serializable{
    public static final long serialVersionUID =1L;
    private Integer cartId;
    private String bookingNum;
    private String movieName;
    private String movieVersion;
    private String watchingTime;
    private String movieImg;
    private String cinemaName;
    private String hallName;
    private Integer totalPrice;
    private String tele;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieVersion() {
        return movieVersion;
    }

    public void setMovieVersion(String movieVersion) {
        this.movieVersion = movieVersion;
    }

    public String getWatchingTime() {
        return watchingTime;
    }

    public void setWatchingTime(String watchingTime) {
        this.watchingTime = watchingTime;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (cartId != null ? !cartId.equals(cart.cartId) : cart.cartId != null) return false;
        if (bookingNum != null ? !bookingNum.equals(cart.bookingNum) : cart.bookingNum != null) return false;
        if (movieName != null ? !movieName.equals(cart.movieName) : cart.movieName != null) return false;
        if (movieVersion != null ? !movieVersion.equals(cart.movieVersion) : cart.movieVersion != null) return false;
        if (watchingTime != null ? !watchingTime.equals(cart.watchingTime) : cart.watchingTime != null) return false;
        if (movieImg != null ? !movieImg.equals(cart.movieImg) : cart.movieImg != null) return false;
        if (cinemaName != null ? !cinemaName.equals(cart.cinemaName) : cart.cinemaName != null) return false;
        if (hallName != null ? !hallName.equals(cart.hallName) : cart.hallName != null) return false;
        if (totalPrice != null ? !totalPrice.equals(cart.totalPrice) : cart.totalPrice != null) return false;
        return tele != null ? tele.equals(cart.tele) : cart.tele == null;

    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (bookingNum != null ? bookingNum.hashCode() : 0);
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (movieVersion != null ? movieVersion.hashCode() : 0);
        result = 31 * result + (watchingTime != null ? watchingTime.hashCode() : 0);
        result = 31 * result + (movieImg != null ? movieImg.hashCode() : 0);
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (hallName != null ? hallName.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (tele != null ? tele.hashCode() : 0);
        return result;
    }
}
