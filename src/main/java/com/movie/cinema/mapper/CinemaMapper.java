package com.movie.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CinemaMapper {
    public List<Map<String, Object>> cinemaList(Map<String, Object> map);
    public Map<String, Object> cinemaDetail(Long idx);
    public void cinemaUpdate(Map<String, Object> map);
}
