package com.movie.cinema.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Movie {

    private Long idx;
    private String title;
    private String productor;
    private String genre;
    private String director;
    private String state;
    private String code;
    private String actors;
    private Timestamp regDate;
    private Timestamp modDate;

    public Movie() {
    }

    public Movie(Long idx, String title, String productor, String genre, String director, String state, String code, String actors, Timestamp regDate, Timestamp modDate) {
        this.idx = idx;
        this.title = title;
        this.productor = productor;
        this.genre = genre;
        this.director = director;
        this.state = state;
        this.code = code;
        this.actors = actors;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
