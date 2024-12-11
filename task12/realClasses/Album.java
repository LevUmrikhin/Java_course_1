package task12.realClasses;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private List<Song> songs;
    private Singer singer;

    private Album(String name, Singer singer){
        this.name = name;
        this.songs = new ArrayList<Song>();
        this.singer = singer;
        singer.getAlbums().add(this);
    }
    public static Album createAlbum(String name, Singer singer){
        return new Album(name, singer);
    }
    public String getName() { return name; }
    public List<Song> getSongs() { return songs; }
    public Singer getSinger() { return singer; }
    @Override
    public String toString() {
        return "Album{name='" + name + "', songs=" + songs + "}";
    }
}