package task12;

import task12.realClasses.Singer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SingerJdbcDao implements SingerDao {
    private final List<Singer> singers; // Use `final` for immutability of reference

    public SingerJdbcDao(List<Singer> singers) {
        this.singers = new ArrayList<>(singers); // Create a modifiable copy
    }

    String url = "jdbc:postgresql://localhost:5432/music";
    String user = "levumrihin";
    String password = "Leoumr0221";

    @Override
    public List<Singer> findSingers() {
        ArrayList<Singer> result = new ArrayList<>();
        String query = "SELECT name FROM singers";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Extract data from the current row
                String name = rs.getString("name");

                // Create a Song object and add it to the ArrayList
                result.add(new Singer(name));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("Singers successfully read from file.");
        return result;
    }

    @Override
    public void saveSingers(List<Singer> singersToSave) {
        // Clear the current list and add new singers
        Path path = Paths.get("/Users/levumrihin/Desktop/Music/MyFile_db.txt");
        String query = "SELECT singer_id, name FROM singers";
        String insertQuery = "INSERT INTO singers_filtered (singer_id, name) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             PreparedStatement targetStmt = conn.prepareStatement(insertQuery);
             BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
             ) {

            writer.write("singer_id, name");
            writer.newLine();

            Set<String> singersToSaveNames = singersToSave.stream()
                    .map(Singer::getName)
                    .collect(Collectors.toSet());

            while (rs.next()) {
                int id = rs.getInt("singer_id");
                String name = rs.getString("name");
                if(singersToSaveNames.contains(name)){
                // Write the data in CSV format
                writer.write(id + ", " + name);
                writer.newLine();
                targetStmt.setInt(1, id);
                targetStmt.setString(2, name);

                // Execute the insert query
                targetStmt.executeUpdate();
                }
            }


            System.out.println("Singers successfully saved to file.");
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Intellij IDEA пункты меню Run -> Edit Configurations -> Program Arguments).
    //Доработать главную программу для возможности выбора используемой
    //фабрики через оператор switch
}

