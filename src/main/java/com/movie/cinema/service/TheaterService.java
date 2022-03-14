package com.movie.cinema.service;

import com.movie.cinema.mapper.CinemaMapper;
import com.movie.cinema.mapper.TheaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TheaterService {

    private TheaterMapper theaterMapper;

    private CinemaMapper cinemaMapper;

    @Autowired
    public TheaterService(TheaterMapper theaterMapper, CinemaMapper cinemaMapper) {
        this.theaterMapper = theaterMapper;
        this.cinemaMapper = cinemaMapper;
    }

    public List<Map<String, Object>> theaterList(Map<String, Object> paramMap) {
        List<Map<String, Object>> theaters = new ArrayList<>();

        theaters.clear();
        theaters.addAll(theaterMapper.theaterList(paramMap));

        return theaters;
    }

    public Map<String, Object> theaterDetail(Long idx) {
        Map<String, Object> theater = new HashMap<>();

        theater.clear();
        theater.putAll(theaterMapper.theaterDetail(idx));
        return theater;
    }
}
