package com.movie.cinema.mapper;

import com.movie.cinema.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findById(String id);
}
