package com.wwwy.liuxing.hall.dto;

import java.io.Serializable;

/**
 *影厅实体类
 * @author W1665
 * @date 2018/4/10
 */
public class HallDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 影厅id
     */
    private Integer hallId;

    /**
     * 影厅名称
     */
    private String hallName;

    /**
     * 影院主键做外键
     */
    private Integer fkTheaterId;


}
