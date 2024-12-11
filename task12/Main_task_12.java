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
        String factoryType;
        if (args.length == 0) {
            factoryType = "SingerFileDaoFactory";
            return;
        } else{
            factoryType = args[0];
        }

        System.out.println(factoryType);

        // Create a Singer
        Singer singer = Singer.createSinger("travis scott");
        Singer singer2 = Singer.createSinger("the beatles");



        // Create an Album for the Singer
        Album album = Album.createAlbum("UTOPIA", singer);
        Album album2 = Album.createAlbum("abbey road", singer2);
        Album album3 = Album.createAlbum("ASTROWORLD", singer);

        // Create Songs for the Album
        Song song1 = Song.createSong("FE-N", 300, album);
        Song song2 = Song.createSong("I-KNOW", 350, album);
        Song song3 = Song.createSong("01 Come Together", 450, album2);
        Song song4 = Song.createSong("07 Here Comes The Sun", 450, album2);
        Song song5 = Song.createSong("09. Travis Scott - 5% TINT", 450, album3);
        Song song6 = Song.createSong("03. Travis Scott - SICKO MODE", 450, album3);

        // Associate Album with Singer





        //create list of singers
        List<Singer> list1 = Arrays.asList(singer, singer2);

        switch (factoryType) {
            case "SingerFileDaoFactory":
                // Initialize DAO Factories
                System.out.println("Using SingerFileDaoFactory");
                SingerFileDaoFactory fileDaoFactory = new SingerFileDaoFactory();

                //
                fileDaoFactory.createSingerDao(list1).findSingers();
                fileDaoFactory.createSingerDao(list1).saveSingers(list1);
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

                jdbcDaoFactory.createSingerDao(list1).findSingers();
                jdbcDaoFactory.createSingerDao(list1).saveSingers(list1);
                SingerService b = new SingerService(jdbcDaoFactory.createSingerDao(list1));
                b.filterByMinAlbumsCount(0);

                SingletonEnum.INSTANCE.addSingerJdbcDaoFactory(jdbcDaoFactory);

                System.out.println(SingletonEnum.INSTANCE);

                System.out.println("JDBC DAO Factories: " + SingletonEnum.INSTANCE.getSingerJdbcDaoFactories());

                break;
        }

    }
}