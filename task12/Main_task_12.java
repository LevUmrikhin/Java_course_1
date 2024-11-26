import ru.isys.trainings.task12.SingerFileDaoFactory;
import ru.isys.trainings.task12.SingerJdbcDaoFactory;
import ru.isys.trainings.task12.SingletonEnum;
import ru.isys.trainings.task12.realClasses.Album;
import ru.isys.trainings.task12.realClasses.Singer;
import ru.isys.trainings.task12.realClasses.Song;
import ru.isys.trainings.task12.*;

import java.util.Arrays;
import java.util.List;

public class Main_task_12 {
    public static void main(String[] args) throws InterruptedException {
        // Create a Singer
        Singer singer = Singer.createSinger("John Doe");
        Singer singer2 = Singer.createSinger("Michael Jackson");
        Singer singer3 = Singer.createSinger("Adele");


        // Create an Album for the Singer
        Album album = Album.createAlbum("Greatest Hits", singer);
        Album album2 = Album.createAlbum("Greatest Hits", singer2);
        Album album3 = Album.createAlbum("Greatest Hits", singer);

        // Create Songs for the Album
        Song song1 = Song.createSong("Hit Song 1", 300, album);
        Song song2 = Song.createSong("Hit Song 2", 350, album);
        Song song3 = Song.createSong("Hit Song 3", 450, album2);
        Song song4 = Song.createSong("Hit Song 4", 450, album2);
        Song song5 = Song.createSong("Hit Song 5", 450, album3);
        Song song6 = Song.createSong("Hit Song 6", 450, album3);

        // Associate Album with Singer
        singer.getAlbums().add(album);
        album.getSongs().add(song1);
        album.getSongs().add(song2);

        singer2.getAlbums().add(album2);
        album2.getSongs().add(song3);
        album2.getSongs().add(song4);

        singer3.getAlbums().add(album3);
        album3.getSongs().add(song5);
        album3.getSongs().add(song6);

        //create list of singers
        List<Singer> list1 = Arrays.asList(singer, singer2, singer3);


        // Initialize DAO Factories
        SingerFileDaoFactory fileDaoFactory = new SingerFileDaoFactory();
        SingerJdbcDaoFactory jdbcDaoFactory = new SingerJdbcDaoFactory();

        //
        fileDaoFactory.createSingerDao(list1).findSingers();
        fileDaoFactory.createSingerDao(list1);
        SingerService a = new SingerService(fileDaoFactory.createSingerDao(list1));
        a.filterByMinAlbumsCount(0);



        // Add DAO Factories to Singleton
        SingletonEnum.INSTANCE.addSingerFileDaoFactory(fileDaoFactory);
        SingletonEnum.INSTANCE.addSingerJdbcDaoFactory(jdbcDaoFactory);

        // Print the Singleton's state
        System.out.println(SingletonEnum.INSTANCE);

        // Example: Access factories from the Singleton
        System.out.println("File DAO Factories: " + SingletonEnum.INSTANCE.getSingerFileDaoFactories());
        System.out.println("JDBC DAO Factories: " + SingletonEnum.INSTANCE.getSingerJdbcDaoFactories());


    }
}
