package com.example.demo;

import com.example.demo.dbClasses.*;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongdbRowMapper implements RowMapper<Songdb> {
    @Override
    public Songdb mapRow(ResultSet rs, int rowNum) throws SQLException {
        String title = rs.getString("title");
        int song_id = rs.getInt("song_id");
        int album_id = rs.getInt("album_id");
        return new Songdb(title, song_id, album_id);
    }
}

