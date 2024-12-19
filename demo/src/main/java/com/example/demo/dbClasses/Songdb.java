package com.example.demo.dbClasses;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Songdb {
    private String title;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int song_id;
    private int album_id;

    public Songdb(String title, int song_id, int album_id) {
        this.title = title;
        this.song_id = song_id;
        this.album_id = album_id;
    }

    public String getTitle() { return title; }
    public int getSong_id() {return song_id; }
    public int getAlbum_id() {return album_id; }
    
}