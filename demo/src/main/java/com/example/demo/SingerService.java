package com.example.demo;

import com.example.demo.realClasses.Singer;
import com.example.demo.dbClasses.Singerdb;
import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SingerService {
    @Autowired
    private SingerdbRepository singerdbRepository;
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
        System.out.println("test_scheduling");
        // Create a modifiable copy of the list
        List<Singer> singers = new ArrayList<>(singerDaoFactory.getDao().findSingers());

        for (Singer singer : singers) {
            if (singer.getAlbums().size() > minAlbumsCount) {
                singerDaoFactory.getDao().saveSingers(singers);
                return;
            }
        }
    }
    @Scheduled(fixedDelay = 2000*60)
    public void filterScheduled() throws InterruptedException {
        filterByMinAlbumsCount(0);
    }

       // Получение всех исполнителей
    public List<Singerdb> getAllSingers() {
        return singerdbRepository.findAll();
    }

    // Получение исполнителей постранично
    public Page<Singerdb> getSingersByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return singerdbRepository.findAll(pageable);
    }

    // Получение исполнителя по id
    public Optional<Singerdb> getSingerById(int id) {
        return singerdbRepository.findById(id);
    }

    // Создание исполнителя
    public Singerdb createSinger(Singerdb singer) {
        return singerdbRepository.save(singer);
    }

    // Замена исполнителя по id
    public Singerdb updateSinger(int id, Singerdb singerDetails) {
        Singerdb singer = singerdbRepository.findById(id).orElseThrow(() -> new RuntimeException("Singer not found"));
        singer.setName(singerDetails.getName());
        return singerdbRepository.save(singer);
    }

    // Удаление исполнителя по id
    public void deleteSinger(int id) {
        singerdbRepository.deleteById(id);
    }
}
