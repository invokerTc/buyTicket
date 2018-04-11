package com.wwwy.liuxing.hall.dto;

import com.wwwy.liuxing.movie.dto.MovieDTO;

import java.io.Serializable;
import java.util.List;

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

    /**
     * 影厅座位的行数
     */
    private Integer hallCoordinateX;

    /**
     * 影厅座位的列数
     */
    private Integer hallCoordinateY;

    /**
     * 影厅对应的电影的集合
     */
    private List<MovieDTO> movieDTOList;

    public List<MovieDTO> getMovieDTOList() {
        return movieDTOList;
    }

    public void setMovieDTOList(List<MovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    public HallDTO() {
    }

    public HallDTO(Integer hallId, String hallName, Integer fkTheaterId, Integer hallCoordinateX, Integer hallCoordinateY) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.fkTheaterId = fkTheaterId;
        this.hallCoordinateX = hallCoordinateX;
        this.hallCoordinateY = hallCoordinateY;
    }

    @Override
    public String toString() {
        return "HallDTO{" +
                "hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", fkTheaterId=" + fkTheaterId +
                ", hallCoordinateX=" + hallCoordinateX +
                ", hallCoordinateY=" + hallCoordinateY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HallDTO hallDTO = (HallDTO) o;

        if (hallId != null ? !hallId.equals(hallDTO.hallId) : hallDTO.hallId != null) return false;
        if (hallName != null ? !hallName.equals(hallDTO.hallName) : hallDTO.hallName != null) return false;
        if (fkTheaterId != null ? !fkTheaterId.equals(hallDTO.fkTheaterId) : hallDTO.fkTheaterId != null) return false;
        if (hallCoordinateX != null ? !hallCoordinateX.equals(hallDTO.hallCoordinateX) : hallDTO.hallCoordinateX != null)
            return false;
        return hallCoordinateY != null ? hallCoordinateY.equals(hallDTO.hallCoordinateY) : hallDTO.hallCoordinateY == null;

    }

    @Override
    public int hashCode() {
        int result = hallId != null ? hallId.hashCode() : 0;
        result = 31 * result + (hallName != null ? hallName.hashCode() : 0);
        result = 31 * result + (fkTheaterId != null ? fkTheaterId.hashCode() : 0);
        result = 31 * result + (hallCoordinateX != null ? hallCoordinateX.hashCode() : 0);
        result = 31 * result + (hallCoordinateY != null ? hallCoordinateY.hashCode() : 0);
        return result;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getFkTheaterId() {
        return fkTheaterId;
    }

    public void setFkTheaterId(Integer fkTheaterId) {
        this.fkTheaterId = fkTheaterId;
    }

    public Integer getHallCoordinateX() {
        return hallCoordinateX;
    }

    public void setHallCoordinateX(Integer hallCoordinateX) {
        this.hallCoordinateX = hallCoordinateX;
    }

    public Integer getHallCoordinateY() {
        return hallCoordinateY;
    }

    public void setHallCoordinateY(Integer hallCoordinateY) {
        this.hallCoordinateY = hallCoordinateY;
    }
}
