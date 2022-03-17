package com.movie.cinema.service;

import com.movie.cinema.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Map<String, Object>> movieList(Map<String, Object> paramMap) {
        List<Map<String, Object>> list = new ArrayList<>();
        list.clear();

        list.addAll(movieMapper.movieList(paramMap));

        return list;
    }
}
