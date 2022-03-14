package com.movie.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TheaterMapper {
    public List<Map<String, Object>> theaterList(Map<String, Object> paramMap);
    public Map<String, Object> theaterDetail(Long idx);
}
