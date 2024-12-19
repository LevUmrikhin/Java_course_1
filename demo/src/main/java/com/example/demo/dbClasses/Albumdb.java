package com.example.demo.dbClasses;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Albumdb {
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int singer_id;
    private int album_id;

    //@ManyToOne
    //private Singerdb singer;

    //@OneToMany(mappedBy = "album")
    //private List<Songdb> songs;


    public Albumdb(String title, int singer_id, int album_id) {
        this.title = title;
        this.singer_id = singer_id;
        this.album_id = album_id;
    }

    public String getTitle() { return title; }
    public int getSinger_id() {return singer_id; }
    public int getAlbum_id() {return album_id; }
    
}