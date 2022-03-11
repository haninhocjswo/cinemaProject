package com.movie.cinema.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public List<Map<String, Object>> memberList(Map<String, Object> map);
    public Map<String, Object> memberDetail(Long idx);
    public void memberUpdate(Map<String, Object> map);
}
