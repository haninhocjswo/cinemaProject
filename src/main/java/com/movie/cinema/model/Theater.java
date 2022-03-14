package com.movie.cinema.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Theater {
    public Long idx;
    public Long cinemaIdx;
    public String name;
    public Integer seats;
    public String state;
    public Timestamp regDate;
    public Timestamp modDate;

    public Theater() {
    }

    public Theater(Long idx, Long cinemaIdx, String name, Integer seats, String state, Timestamp regDate, Timestamp modDate) {
        this.idx = idx;
        this.cinemaIdx = cinemaIdx;
        this.name = name;
        this.seats = seats;
        this.state = state;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
