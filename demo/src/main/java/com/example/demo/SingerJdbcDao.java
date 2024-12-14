package com.example.demo;

import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Song;

import jakarta.annotation.PostConstruct;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class SingerJdbcDao implements SingerDao {
    
    @Override
    public void SetList(List<Singer> singers){
        this.singers.addAll(singers);
    }

    public SingerJdbcDao() {
        this.singers = new ArrayList<>(); // Create a modifiable copy
    }
    private final List<Singer> singers; // Use `final` for immutability of reference

    public SingerJdbcDao(List<Singer> singers) {
        this.singers = new ArrayList<>(singers); // Create a modifiable copy
    }
    @Value("${data.singer.dao.jdbc.url}")
    private String N_URL;

    @Value("${data.singer.dao.jdbc.username}")
    private String N_USER;

    @Value("${data.singer.dao.jdbc.password}")
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
    public List<Singer> findSingers() {
        List<Singer> result = new ArrayList<>();
        String query = "SELECT name FROM singers";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                result.add(new Singer(name));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching singers: " + e.getMessage());
        }

        System.out.println("Singers successfully read from database.");
        return result;
    }

    @Override
    public void saveSingers(List<Singer> singersToSave) {
        String query = "SELECT singer_id, name FROM singers";
        String query2 = "SELECT album_id, title FROM albums WHERE singer_id = ?";
        String query3 = "SELECT song_id, title FROM songs WHERE album_id = ?";
        String insertQuery = "INSERT INTO singers_filtered (singer_id, name) VALUES (?, ?)";
        String insertQuery2 = "INSERT INTO songs_filtered (song_id, title, album_id) VALUES (?, ?, ?)";
        String insertQuery3 = "INSERT INTO albums_filtered (album_id, title, singer_id) VALUES (?, ?, ?)";
        String truncateQuery = "TRUNCATE TABLE singers_filtered";
        String truncateQuery2 = "TRUNCATE TABLE songs_filtered";
        String truncateQuery3 = "TRUNCATE TABLE albums_filtered";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement truncateStmt = conn.prepareStatement(truncateQuery);
             PreparedStatement truncateStmt2 = conn.prepareStatement(truncateQuery2);
             PreparedStatement truncateStmt3 = conn.prepareStatement(truncateQuery3);
             PreparedStatement selectSingersStmt = conn.prepareStatement(query);
             PreparedStatement selectAlbumsStmt = conn.prepareStatement(query2);
             PreparedStatement selectSongsStmt = conn.prepareStatement(query3);
             PreparedStatement insertSingerStmt = conn.prepareStatement(insertQuery);
             PreparedStatement insertAlbumStmt = conn.prepareStatement(insertQuery3);
             PreparedStatement insertSongStmt = conn.prepareStatement(insertQuery2)) {

            truncateStmt.executeUpdate();
            truncateStmt2.executeUpdate();
            truncateStmt3.executeUpdate();

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


            try (ResultSet rs = selectSingersStmt.executeQuery()) {
                while (rs.next()) {
                    int singerId = rs.getInt("singer_id");
                    String name = rs.getString("name");

                    if (singersToSaveNames.contains(name)) {
                        insertSingerStmt.setInt(1, singerId);
                        insertSingerStmt.setString(2, name);
                        insertSingerStmt.executeUpdate();

                        selectAlbumsStmt.setInt(1, singerId);
                        try (ResultSet albumsRs = selectAlbumsStmt.executeQuery()) {
                            while (albumsRs.next()) {
                                int albumId = albumsRs.getInt("album_id");
                                String albumTitle = albumsRs.getString("title");



                                if (singersToSaveAlbums.contains(albumTitle)) {
                                    insertAlbumStmt.setInt(1, albumId);
                                    insertAlbumStmt.setString(2, albumTitle);
                                    insertAlbumStmt.setInt(3, singerId);
                                    insertAlbumStmt.executeUpdate();

                                    selectSongsStmt.setInt(1, albumId);
                                    try (ResultSet songsRs = selectSongsStmt.executeQuery()) {
                                        while (songsRs.next()) {
                                            int songId = songsRs.getInt("song_id");
                                            String songTitle = songsRs.getString("title");



                                            if (singersToSaveSongs.contains(songTitle)) {
                                                insertSongStmt.setInt(1, songId);
                                                insertSongStmt.setString(2, songTitle);
                                                insertSongStmt.setInt(3, albumId);
                                                insertSongStmt.executeUpdate();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Singers successfully saved to database.");
        } catch (SQLException e) {
            System.err.println("Error saving singers: " + e.getMessage());
        }
    }
}