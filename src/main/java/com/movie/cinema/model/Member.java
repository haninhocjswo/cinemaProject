package com.movie.cinema.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Member {
    private Long idx;
    private String name;
    private String mobile;
    private String post;
    private String address;
    private String addressDetail;
    private String grade;
    private Integer point;
    private String profile;
    private Timestamp regDate;
    private Timestamp modDate;

    public Member() {
    }

    public Member(Long idx, String name, String mobile, String post, String address, String addressDetail, String grade, Integer point, String profile, Timestamp regDate, Timestamp modDate) {
        this.idx = idx;
        this.name = name;
        this.mobile = mobile;
        this.post = post;
        this.address = address;
        this.addressDetail = addressDetail;
        this.grade = grade;
        this.point = point;
        this.profile = profile;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
