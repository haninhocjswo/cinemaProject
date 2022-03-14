package com.movie.cinema.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Cinema {
    public Long idx;
    public String name;
    public String code;
    public String post;
    public String address;
    public String addressDetail;
    public String state;
    public String tel;
    public Integer sort;
    public Timestamp regDate;
    public Timestamp modDate;

    public Cinema() {
    }

    public Cinema(Long idx, String name, String code, String post, String address, String addressDetail, String state, String tel, Integer sort, Timestamp regDate, Timestamp modDate) {
        this.idx = idx;
        this.name = name;
        this.code = code;
        this.post = post;
        this.address = address;
        this.addressDetail = addressDetail;
        this.state = state;
        this.tel = tel;
        this.sort = sort;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
