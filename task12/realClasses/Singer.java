package task12.realClasses;
import java.util.*;
public class Singer {
    private String name;
    private List<Album> albums;

    public Singer(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public static Singer createSinger(String name) {
        return new Singer(name); // Factory method
    }

    public String getName() { return name; }
    public List<Album> getAlbums() { return albums; }
    @Override
    public String toString() {
        return "Singer{name='" + name + "', albums=" + albums + "}";
    }
}
