package com.example.demo;

import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Song;


import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;


public class SingerFileDao implements SingerDao {
    private final List<Singer> singers; // Use `final` for immutability of reference
   

    @Override
    public void SetList(List<Singer> singers){
        this.singers.addAll(singers);
    }

    public SingerFileDao() {
        this.singers = new ArrayList<>(); // Create a modifiable copy
    }

    @Override
    public List<Singer> findSingers() {
        Path start = Paths.get("/Users/levumrihin/Desktop/Music");
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
    public void saveSingers(List<Singer> singersToSave) {
        // Clear the current list and add new singers
        //createFile
        Path start = Paths.get("/Users/levumrihin/Desktop/Music");
        Path path = Paths.get("/Users/levumrihin/Desktop/Music/MyFile_file.txt");
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