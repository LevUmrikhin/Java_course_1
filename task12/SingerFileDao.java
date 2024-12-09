package task12;

import task12.realClasses.Singer;

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

    public SingerFileDao(List<Singer> singers) {
        this.singers = new ArrayList<>(singers); // Create a modifiable copy
    }

    @Override
    public List<Singer> findSingers() {
        Path start = Paths.get("/Users/levumrihin/Desktop/Music");
        ArrayList<Singer> result = new ArrayList<>();
        try {
            Files.list(start)
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
            Set<String> singersToSaveNames = singersToSave.stream()
                    .map(Singer::getName)
                    .collect(Collectors.toSet());

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);


            for(String line : lines) {
                String name = line.trim();
                if (singersToSaveNames.contains(name)) {
                    Files.write(path, (name + "\n").getBytes(), StandardOpenOption.APPEND);
                }
            }

            System.out.println("Singers successfully saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}