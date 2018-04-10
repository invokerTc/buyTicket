package com.wwwy.liuxing.city.dto;

import java.io.Serializable;

/**
 *城市实体类
 * @author W1665
 * @date 2018/4/10
 */
public class CityDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 城市名称
     */
    private String cityName;

    public CityDTO() {
    }

    public CityDTO(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
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

        CityDTO cityDTO = (CityDTO) o;

        if (cityId != null ? !cityId.equals(cityDTO.cityId) : cityDTO.cityId != null) {
            return false;
        }
        return cityName != null ? cityName.equals(cityDTO.cityName) : cityDTO.cityName == null;

    }

    @Override
    public int hashCode() {
        int result = cityId != null ? cityId.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
