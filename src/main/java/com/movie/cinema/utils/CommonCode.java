package com.movie.cinema.utils;

public final class CommonCode {
    //유저 상태
    public static final String MEMBER_STATE_USE = "100";
    public static final String MEMBER_STATE_DORMANT = "200";
    public static final String MEMBER_STATE_DEL = "300";

    //영화관 상태
    public static final String CINEMA_STATE_WAIT = "100";
    public static final String CINEMA_STATE_OPEN = "200";
    public static final String CINEMA_STATE_CLOSE = "300";

    //상영관 상태
    public static final String THEATER_STATE_WAIT = "100";
    public static final String THEATER_STATE_OPEN = "200";
    public static final String THEATER_STATE_CLOSE = "300";

    //영화 상태
    public static final String MOVIE_STATE_WAIT = "100";    //개봉예정
    public static final String MOVIE_STATE_OPEN = "200";    //개봉
    public static final String MOVIE_STATE_CLOSE = "300";   //폐막
}
