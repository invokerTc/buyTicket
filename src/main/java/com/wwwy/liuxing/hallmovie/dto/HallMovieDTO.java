package com.wwwy.liuxing.hallmovie.dto;

import java.io.Serializable;

/**
 *
 * @author W1665
 * @date 2018/4/10
 */
public class HallMovieDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 影厅和电影中间表的主键
     */
    private Integer haMoId;

    /**
     * 影厅外键
     */
    private Integer fkHallId;

    /**
     * 电影外键
     */
    private Integer fkMovieId;

    /**
     * 电影上映时间
     */
    private String movieRuntime;

    /**
     * 电影价格
     */
    private Integer moviePrice;

    /**
     * 电影版本
     */
    private String movieVersion;

    public HallMovieDTO() {
    }

    public HallMovieDTO(Integer haMoId, Integer fkHallId, Integer fkMovieId, String movieRuntime, Integer moviePrice, String movieVersion) {
        this.haMoId = haMoId;
        this.fkHallId = fkHallId;
        this.fkMovieId = fkMovieId;
        this.movieRuntime = movieRuntime;
        this.moviePrice = moviePrice;
        this.movieVersion = movieVersion;
    }

    @Override
    public String toString() {
        return "HallMovieDTO{" +
                "haMoId=" + haMoId +
                ", fkHallId=" + fkHallId +
                ", fkMovieId=" + fkMovieId +
                ", movieRuntime='" + movieRuntime + '\'' +
                ", moviePrice=" + moviePrice +
                ", movieVersion='" + movieVersion + '\'' +
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

        HallMovieDTO that = (HallMovieDTO) o;

        if (haMoId != null ? !haMoId.equals(that.haMoId) : that.haMoId != null) {
            return false;
        }
        if (fkHallId != null ? !fkHallId.equals(that.fkHallId) : that.fkHallId != null) {
            return false;
        }
        if (fkMovieId != null ? !fkMovieId.equals(that.fkMovieId) : that.fkMovieId != null) {
            return false;
        }
        if (movieRuntime != null ? !movieRuntime.equals(that.movieRuntime) : that.movieRuntime != null) {
            return false;
        }
        return moviePrice != null ? moviePrice.equals(that.moviePrice) : that.moviePrice == null && (movieVersion != null ? movieVersion.equals(that.movieVersion) : that.movieVersion == null);

    }

    @Override
    public int hashCode() {
        int result = haMoId != null ? haMoId.hashCode() : 0;
        result = 31 * result + (fkHallId != null ? fkHallId.hashCode() : 0);
        result = 31 * result + (fkMovieId != null ? fkMovieId.hashCode() : 0);
        result = 31 * result + (movieRuntime != null ? movieRuntime.hashCode() : 0);
        result = 31 * result + (moviePrice != null ? moviePrice.hashCode() : 0);
        result = 31 * result + (movieVersion != null ? movieVersion.hashCode() : 0);
        return result;
    }

    public Integer getHaMoId() {
        return haMoId;
    }

    public void setHaMoId(Integer haMoId) {
        this.haMoId = haMoId;
    }

    public Integer getFkHallId() {
        return fkHallId;
    }

    public void setFkHallId(Integer fkHallId) {
        this.fkHallId = fkHallId;
    }

    public Integer getFkMovieId() {
        return fkMovieId;
    }

    public void setFkMovieId(Integer fkMovieId) {
        this.fkMovieId = fkMovieId;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(String movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public Integer getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Integer moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieVersion() {
        return movieVersion;
    }

    public void setMovieVersion(String movieVersion) {
        this.movieVersion = movieVersion;
    }
}
