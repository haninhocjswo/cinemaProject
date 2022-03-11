package com.movie.cinema.service;

import com.movie.cinema.mapper.MemberMapper;
import com.movie.cinema.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private UserMapper userMapper;
    private MemberMapper memberMapper;

    @Autowired
    public MemberService(UserMapper userMapper, MemberMapper memberMapper) {
        this.userMapper = userMapper;
        this.memberMapper = memberMapper;
    }

    public List<Map<String, Object>> memberList(Map<String, Object> map) {
        List<Map<String, Object>> memberList = new ArrayList<>();
        memberList.clear();
        memberList.addAll(memberMapper.memberList(map));
        return memberList;
    }

    public Map<String, Object> memberDetail(Long idx) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.clear();

        resultMap.putAll(memberMapper.memberDetail(idx));
        return resultMap;
    }

    public void memberUpdate(Map<String, Object> map) {
        userMapper.userUpdate(map);
        memberMapper.memberUpdate(map);
    }

    public void memberDel(Map<String, Object> map) {
        userMapper.userUpdate(map);
    }
}
