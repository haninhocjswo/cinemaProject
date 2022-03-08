package com.movie.cinema.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Long idx;
    private String id;
    private String passwd;
    private String status;
    private Timestamp regDate;
    private Timestamp modDate;

    public User() {
    }

    public User(Long idx, String id, String passwd, String status, Timestamp regDate, Timestamp modDate) {
        this.idx = idx;
        this.id = id;
        this.passwd = passwd;
        this.status = status;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
