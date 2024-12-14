package com.example.demo;

import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Song;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SingerService {
    private final SingerDaoFactory singerDaoFactory;

    public SingerService(SingerDaoFactory singerDaoFactory) {
        this.singerDaoFactory = singerDaoFactory;
    }

    public void filterBySongName(String songName) throws InterruptedException {
        // Create a modifiable copy of the list
        List<Singer> singers = new ArrayList<>(singerDaoFactory.getDao().findSingers());

        for (Singer singer : singers) {
            for (Album album : singer.getAlbums()) {
                for (Song song : album.getSongs()) {
                    if (song.getTitle().equals(songName)) {
                        singerDaoFactory.getDao().saveSingers(singers);
                        return;
                    }
                }
            }
        }
    }

    public void filterByMinAlbumsCount(int minAlbumsCount) throws InterruptedException {
        // Create a modifiable copy of the list
        List<Singer> singers = new ArrayList<>(singerDaoFactory.getDao().findSingers());

        for (Singer singer : singers) {
            if (singer.getAlbums().size() > minAlbumsCount) {
                singerDaoFactory.getDao().saveSingers(singers);
                return;
            }
        }
    }
}
