package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Song;

@SpringBootApplication //equivalent to @ComponentScan
@ComponentScan(basePackages = "com.example.demo")
public class Application {
       
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext=SpringApplication.run(Application.class, args);



        // Create a Singer
        Singer singer = Singer.createSinger("travis scott");
        Singer singer2 = Singer.createSinger("the beatles");



        // Create an Album for the Singer
        Album album = Album.createAlbum("UTOPIA", singer);
        Album album2 = Album.createAlbum("abbey road", singer2);
        Album album3 = Album.createAlbum("ASTROWORLD", singer);

        // Create Songs for the Album
        Song.createSong("FE-N", 300, album);
        Song.createSong("I-KNOW", 350, album);
        Song.createSong("01 Come Together", 450, album2);
        Song.createSong("07 Here Comes The Sun", 450, album2);
        Song.createSong("09. Travis Scott - 5% TINT", 450, album3);
        Song.createSong("03. Travis Scott - SICKO MODE", 450, album3);

        // Associate Album with Singer

        

        //create list of singers
        List<Singer> list1 = Arrays.asList(singer, singer2);

        
              //  SingerFileDaoFactory fileDaoFactory = new SingerFileDaoFactory();
              SingerDaoFactory daoFactory = applicationContext.getBean(SingerDaoFactory.class);
                daoFactory.getDao().SetList(list1);
                //
                daoFactory.getDao().findSingers();
                daoFactory.getDao().saveSingers(list1);
                SingerService a = applicationContext.getBean(SingerService.class);
                a.filterByMinAlbumsCount(0);


    }

}

