package com.movie.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {
    public List<Map<String, Object>> movieList(Map<String, Object> paramMap);
    public void movieSave(Map<String, Object> paramMap);
    public void movieUpdate(Map<String, Object> paramMap);
    public void movieDel(Long idx);
}
