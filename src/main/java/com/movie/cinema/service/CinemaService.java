package com.movie.cinema.service;

import com.movie.cinema.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Service
public class CinemaService {

    private CinemaMapper cinemaMapper;

    @Autowired
    public CinemaService(CinemaMapper cinemaMapper) {
        this.cinemaMapper = cinemaMapper;
    }

    public List<Map<String, Object>> cinemaList(Map<String, Object> map) {
        List<Map<String, Object>> cinemas = cinemaMapper.cinemaList(map);
        return cinemas;
    }

    public Map<String, Object> cinemaDetail(Long idx) {
        return cinemaMapper.cinemaDetail(idx);
    }
}
