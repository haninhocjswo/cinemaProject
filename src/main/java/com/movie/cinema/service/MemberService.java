package com.movie.cinema.service;

import com.movie.cinema.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Map<String, Object>> memberList(Map<String, Object> map) {
        List<Map<String, Object>> memberList = new ArrayList<>();
        memberList.clear();
        memberList.addAll(memberMapper.memberList(map));
        return memberList;
    }
}
