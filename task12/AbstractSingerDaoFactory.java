package task12;

import task12.realClasses.Singer;

import java.util.List;

public interface AbstractSingerDaoFactory {
    public SingerDao createSingerDao(List<Singer> singers) throws InterruptedException;
}
