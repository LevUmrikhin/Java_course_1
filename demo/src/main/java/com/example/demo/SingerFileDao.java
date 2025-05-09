package com.example.demo;

import com.codahale.metrics.annotation.Timed;
import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Song;

import io.astefanutti.metrics.aspectj.Metrics;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.stream.Collectors;

@Component
@Primary
@Metrics
public class SingerFileDao implements SingerDao {
    private final List<Singer> singers; // Use `final` for immutability of reference
   

    @Override
    public void SetList(List<Singer> singers){
        this.singers.addAll(singers);
    }

    public SingerFileDao() {
        this.singers = new ArrayList<>(); // Create a modifiable copy
    }
    
    @Value("${data.singer.dao.file.input}")
    private String inputFile;

    @Value("${data.singer.dao.file.output}")
    private String outputFile;

    @PostConstruct
    public void init() {
        System.out.println("Input file path: " + inputFile);
        System.out.println("Output file path: " + outputFile);
    }
    @Override
    public List<Singer> findSingers() {
        System.out.println("Input file path: " + inputFile);
        Path start = Paths.get(inputFile);
        List<Singer> result = new ArrayList<>();
        try {
           result= Files.list(start)
                    .filter(Files::isDirectory) // Only directories
                    .map(path -> new Singer(path.getFileName().toString())) // Get just the folder name
                    .collect(Collectors.toList()); // Print each name
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return a defensive copy to avoid external modifications
        System.out.println("Singers successfully read from file.");
        return new ArrayList<>(result);
    }

    @Override
    @Timed
    public void saveSingers(List<Singer> singersToSave) {
        // Clear the current list and add new singers
        //createFile
        
        Path start = Paths.get(inputFile);
        Path path = Paths.get(outputFile);
        try {
            // Create the file if it does not already exist
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("File created successfully.");
            } else {
                Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING).close();
            }




            Files.list(start)
                        .filter(Files::isDirectory).forEach(directory -> {
                            for(Singer singer : singersToSave) {

                                if (singer.getName().equals(directory.getFileName().toString())) {
                                    try {
                                        Files.write(path, (directory.getFileName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Directory: " + directory.getFileName().toString());
                                    try {
                                        Files.list(directory)
                                                .filter(Files::isDirectory).forEach(directoryalbum -> {
                                                    for (Album album : singer.getAlbums()) {

                                                        if (album.getName().equals(directoryalbum.getFileName().toString())) {
                                                            try {
                                                                Files.write(path, ("\t" + directoryalbum.getFileName().toString() + "\n").getBytes(), StandardOpenOption.APPEND);
                                                            } catch (IOException e) {
                                                                throw new RuntimeException(e);
                                                            }
                                                            System.out.println("Album: " + directoryalbum.getFileName().toString());
                                                            try{
                                                                Files.list(directoryalbum)
                                                                        .forEach(filesong-> {
                                                                            for (Song song : album.getSongs()) {

                                                                                if (song.getTitle().equals(filesong.getFileName().toString().replaceFirst("[.][^.]+$", ""))) {
                                                                                    try {
                                                                                        Files.write(path, ("\t" + "\t" + filesong.getFileName().toString().replaceFirst("[.][^.]+$", "") + "\n").getBytes(), StandardOpenOption.APPEND);
                                                                                    } catch (IOException e) {
                                                                                        throw new RuntimeException(e);
                                                                                    }
                                                                                    System.out.println("Song: " + filesong.getFileName().toString().replaceFirst("[.][^.]+$", ""));
                                                                                }
                                                                            }

                                                                        });
                                                            } catch (IOException e){
                                                                throw new RuntimeException(e);
                                                            }
                                                        }
                                                    }

                                                });
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Singers successfully saved to file.");

                                }
                            }




            });
            System.out.println("Singers successfully saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}