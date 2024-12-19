package com.example.demo;

import org.springframework.jdbc.core.RowMapper;
import com.example.demo.realClasses.Singer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SingerRowMapper implements RowMapper<Singer> {
    @Override
    public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        return Singer.createSinger(name);
    }
}

