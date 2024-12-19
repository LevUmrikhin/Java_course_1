package com.example.demo;
import com.example.demo.dbClasses.*;
import com.codahale.metrics.annotation.Timed;
import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Song;

import io.astefanutti.metrics.aspectj.Metrics;
import jakarta.annotation.PostConstruct;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Metrics
public class SingerSpringDao implements SingerDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public void SetList(List<Singer> singers){
        this.singers.addAll(singers);
    }

    public SingerSpringDao(JdbcTemplate jdbcTemplate) {
        this.singers = new ArrayList<>(); // Create a modifiable copy
        this.jdbcTemplate = jdbcTemplate;
    }
    private final List<Singer> singers; // Use `final` for immutability of reference

    //public SingerSpringDao(List<Singer> singers, JdbcTemplate jdbcTemplate) {
        //this.singers = new ArrayList<>(singers); // Create a modifiable copy
        //this.jdbcTemplate = jdbcTemplate;
    //}
    @Value("${spring.datasource.url}")
    private String N_URL;

    @Value("${spring.datasource.username}")
    private String N_USER;

    @Value("${spring.datasource.password}")
    private String N_PASSWORD;

    private static String URL;
    private static String USER;
    private static String PASSWORD;


    @PostConstruct
    private void initStaticFields() {
        URL = N_URL;
        USER = N_USER;
        PASSWORD = N_PASSWORD;
    }

   

    @Override
    @Timed
    public List<Singer> findSingers() {
        List<Singer> result = new ArrayList<>();
        String query = "SELECT name FROM singers";
        result = jdbcTemplate.query(
             query,
             new SingerRowMapper()
             );

        System.out.println("Singers successfully read from database.");
        return result;
    }


    


    @Override
    public void saveSingers(List<Singer> singersToSave) {
        String query = "SELECT singer_id, name FROM singers";
        String query2 = "SELECT album_id, title, singer_id FROM albums WHERE singer_id = ?";
        String query3 = "SELECT song_id, title, album_id FROM songs WHERE album_id = ?";
        String insertQuery = "INSERT INTO singers_filtered_spring (singer_id, name) VALUES (?, ?)";
        String insertQuery3 = "INSERT INTO songs_filtered_spring (song_id, title, album_id) VALUES (?, ?, ?)";
        String insertQuery2 = "INSERT INTO albums_filtered_spring (album_id, title, singer_id) VALUES (?, ?, ?)";
        String truncateQuery = "DELETE FROM singers_filtered_spring";
        String truncateQuery2 = "DELETE FROM songs_filtered_spring";
        String truncateQuery3 = "DELETE FROM albums_filtered_spring";

        jdbcTemplate.execute(truncateQuery3);
            jdbcTemplate.execute(truncateQuery);
            jdbcTemplate.execute(truncateQuery2);

            Set<String> singersToSaveNames = singersToSave.stream()
                    .map(Singer::getName)
                    .collect(Collectors.toSet());
            Set<String> singersToSaveAlbums = new HashSet<>(); // For album titles
            Set<String> singersToSaveSongs = new HashSet<>();

            for (Singer singer : singersToSave) {
                for (Album album : singer.getAlbums()) {
                    singersToSaveAlbums.add(album.getName());
                    for (Song song : album.getSongs()) {
                        singersToSaveSongs.add(song.getTitle());

                    }
                }
            }

            
            for(Singerdb singerdb : jdbcTemplate.query(query, new SingerdbRowMapper())){
                if (singersToSaveNames.contains(singerdb.getName())) {
                    jdbcTemplate.update(insertQuery, singerdb.getSinger_id(), singerdb.getName());
                    for(Albumdb albumdb : jdbcTemplate.query(query2, new AlbumdbRowMapper(), singerdb.getSinger_id())){
                        if(singersToSaveAlbums.contains(albumdb.getTitle())){
                            jdbcTemplate.update(insertQuery2, albumdb.getAlbum_id(), albumdb.getTitle(), singerdb.getSinger_id());
                            for(Songdb songdb : jdbcTemplate.query(query3, new SongdbRowMapper(), albumdb.getAlbum_id())){
                                if(singersToSaveSongs.contains(songdb.getTitle())){
                                    jdbcTemplate.update(insertQuery3, songdb.getSong_id(), songdb.getTitle(), albumdb.getAlbum_id());
                            }
                        }
                }
                System.out.println("Singers successfully saved to database.");

            } 
            


             

        
    }
}
    }
}
    
