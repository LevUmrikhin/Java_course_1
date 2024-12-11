package task12;

import task12.realClasses.Singer;
import task12.realClasses.Album;
import task12.realClasses.Song;

import java.util.ArrayList;
import java.util.List;

public class SingerService {
    private final SingerDao singerDao;

    public SingerService(SingerDao singerDao) {
        this.singerDao = singerDao;
    }

    public void filterBySongName(String songName) throws InterruptedException {
        // Create a modifiable copy of the list
        List<Singer> singers = new ArrayList<>(singerDao.findSingers());

        for (Singer singer : singers) {
            for (Album album : singer.getAlbums()) {
                for (Song song : album.getSongs()) {
                    if (song.getTitle().equals(songName)) {
                        singerDao.saveSingers(singers);
                        return;
                    }
                }
            }
        }
    }

    public void filterByMinAlbumsCount(int minAlbumsCount) throws InterruptedException {
        // Create a modifiable copy of the list
        List<Singer> singers = new ArrayList<>(singerDao.findSingers());

        for (Singer singer : singers) {
            if (singer.getAlbums().size() > minAlbumsCount) {
                singerDao.saveSingers(singers);
                return;
            }
        }
    }
}
