package com.wwwy.liuxing.area.dto;

import java.io.Serializable;

/**
 *地区实体类
 * @author W1665
 * @date 2018/4/10
 */
public class AreaDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 地区id
     */
    private Integer areaId;

    /**
     * 地区名称
     */
    private String areaName;

    public AreaDTO() {
    }

    public AreaDTO(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "AreaDTO{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AreaDTO areaDTO = (AreaDTO) o;

        if (areaId != null ? !areaId.equals(areaDTO.areaId) : areaDTO.areaId != null) {
            return false;
        }
        return areaName != null ? areaName.equals(areaDTO.areaName) : areaDTO.areaName == null;

    }

    @Override
    public int hashCode() {
        int result = areaId != null ? areaId.hashCode() : 0;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        return result;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
