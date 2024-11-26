package ru.isys.trainings.task12;

import ru.isys.trainings.task12.realClasses.Singer;

import java.util.List;

public interface AbstractSingerDaoFactory {
    public Object createSingerDao(List<Singer> singers) throws InterruptedException;
}
