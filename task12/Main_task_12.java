package task12;

import task12.SingerFileDaoFactory;
import task12.SingerJdbcDaoFactory;
import task12.SingletonEnum;
import task12.realClasses.Album;
import task12.realClasses.Singer;
import task12.realClasses.Song;
import task12.*;

import java.util.Arrays;
import java.util.List;

public class Main_task_12 {
    public static void main(String[] args) throws InterruptedException {

        if (args.length == 0) {
            System.out.println("Please specify a factory type as an argument.");
            return;
        }
        String factoryType = args[0];

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

        switch (factoryType) {
            case "SingerFileDaoFactory":
                // Initialize DAO Factories
                System.out.println("Using SingerFileDaoFactory");
                SingerFileDaoFactory fileDaoFactory = new SingerFileDaoFactory();


                //
                fileDaoFactory.createSingerDao(list1).findSingers();
                fileDaoFactory.createSingerDao(list1);
                SingerService a = new SingerService(fileDaoFactory.createSingerDao(list1));
                a.filterByMinAlbumsCount(0);


                // Add DAO Factories to Singleton
                SingletonEnum.INSTANCE.addSingerFileDaoFactory(fileDaoFactory);

                // Print the Singleton's state
                System.out.println(SingletonEnum.INSTANCE);

                // Example: Access factories from the Singleton
                System.out.println("File DAO Factories: " + SingletonEnum.INSTANCE.getSingerFileDaoFactories());

                break;
            case "SingerJdbcDaoFactory":
                System.out.println("Using SingerJdbcDaoFactory");
                SingerJdbcDaoFactory jdbcDaoFactory = new SingerJdbcDaoFactory();
                SingletonEnum.INSTANCE.addSingerJdbcDaoFactory(jdbcDaoFactory);
                System.out.println("JDBC DAO Factories: " + SingletonEnum.INSTANCE.getSingerJdbcDaoFactories());
                break;
        }

    }
}