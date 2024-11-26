package ru.isys.trainings.task12;
import ru.isys.trainings.task12.SingerFileDaoFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public enum SingletonEnum {
    INSTANCE;

    private final List<SingerFileDaoFactory> singerFileDaoFactories = new CopyOnWriteArrayList<>();
    private final List<SingerJdbcDaoFactory> singerJdbcDaoFactories = new CopyOnWriteArrayList<>();

    public void addSingerFileDaoFactory(SingerFileDaoFactory singerFileDaoFactory) {
        if (singerFileDaoFactory != null) {
            singerFileDaoFactories.add(singerFileDaoFactory);
        }
    }

    public void addSingerJdbcDaoFactory(SingerJdbcDaoFactory singerJdbcDaoFactory) {
        if (singerJdbcDaoFactory != null) {
            singerJdbcDaoFactories.add(singerJdbcDaoFactory);
        }
    }

    public List<SingerFileDaoFactory> getSingerFileDaoFactories() {
        return new ArrayList<>(singerFileDaoFactories); // Return a copy to prevent modification
    }

    public List<SingerJdbcDaoFactory> getSingerJdbcDaoFactories() {
        return new ArrayList<>(singerJdbcDaoFactories); // Return a copy to prevent modification
    }

    @Override
    public String toString() {
        return "SingletonEnum{" +
                "singerFileDaoFactories=" + singerFileDaoFactories +
                ", singerJdbcDaoFactories=" + singerJdbcDaoFactories +
                '}';
    }
}
