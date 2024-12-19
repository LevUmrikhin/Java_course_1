package com.example.demo;

import com.example.demo.dbClasses.*;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumdbRowMapper implements RowMapper<Albumdb> {
    @Override
    public Albumdb mapRow(ResultSet rs, int rowNum) throws SQLException {
        String title = rs.getString("title");
        int singer_id = rs.getInt("singer_id");
        int album_id = rs.getInt("album_id");
        return new Albumdb(title, singer_id, album_id);
    }
}

