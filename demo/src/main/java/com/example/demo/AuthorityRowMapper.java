package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.dbClasses.Authority;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorityRowMapper implements RowMapper<Authority> {
    @Override
    public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("username");
        String authority = rs.getString("authority");
        return new Authority(name, authority);
    }
}

