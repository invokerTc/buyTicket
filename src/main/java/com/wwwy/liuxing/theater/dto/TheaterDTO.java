package com.wwwy.liuxing.theater.dto;

import java.io.Serializable;

/**
 *电影院实体类
 * @author W1665
 * @date 2018/4/10
 */
public class TheaterDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 电影院id
     */
    private Integer theaterId;

    /**
     * 电影院名字
     */
    private String theaterName;

    /**
     * 电影院地址
     */
    private String theaterAddress;

    /**
     * 电影院电话
     */
    private String theaterPhone;

    /**
     * 电影院
     */
}
