package com.example.demo.dbClasses;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity

public class Singerdb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int singer_id;

  
    private String name;

    public Singerdb(String name, int singer_id) {
        this.name = name;
        this.singer_id = singer_id;
    }

    public String getName() { return name; }
    public int getSinger_id() {return singer_id; }
    

}