package com.movie.cinema.mapper;

import com.movie.cinema.model.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {
    public List<Map<String, Object>> movieList(Map<String, Object> paramMap);
    public int movieByCode(String code);
    public Movie movieDetail(Long idx);
    public void movieSave(Movie movie);
    public void movieUpdate(Movie movie);
    public void movieDel(Long idx);
}
