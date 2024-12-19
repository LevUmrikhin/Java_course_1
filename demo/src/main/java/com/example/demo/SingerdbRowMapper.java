package com.example.demo;

import com.example.demo.dbClasses.*;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SingerdbRowMapper implements RowMapper<Singerdb> {
    @Override
    public Singerdb mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        int singer_id = rs.getInt("singer_id");
        return new Singerdb(name, singer_id);
    }
}

