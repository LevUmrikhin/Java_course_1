package ru.isys.trainings.task12;

import ru.isys.trainings.task12.realClasses.Singer;

import java.util.ArrayList;
import java.util.List;

public class SingerFileDao implements SingerDao {
    private final List<Singer> singers; // Use `final` for immutability of reference

    public SingerFileDao(List<Singer> singers) {
        this.singers = new ArrayList<>(singers); // Create a modifiable copy
    }

    @Override
    public List<Singer> findSingers() {
        // Return a defensive copy to avoid external modifications
        System.out.println("Singers successfully read from file.");
        return new ArrayList<>(singers);
    }

    @Override
    public void saveSingers(List<Singer> singersToSave) {
        // Clear the current list and add new singers
        singers.clear();
        singers.addAll(singersToSave);
        System.out.println("Singers successfully saved to file.");
    }
}
