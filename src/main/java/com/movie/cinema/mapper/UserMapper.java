package com.movie.cinema.mapper;

import com.movie.cinema.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    public User findById(String id);
    public void userUpdate(Map<String, Object> map);
}
