package com.movie.cinema;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class DbConnectionTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connection_test() {
        try(Connection con = sqlSessionFactory.openSession().getConnection()) {
            System.out.println("db 커넥트 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
