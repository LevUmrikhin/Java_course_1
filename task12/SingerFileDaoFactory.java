package ru.isys.trainings.task12;

import ru.isys.trainings.task12.realClasses.Singer;

import java.util.List;

public class SingerFileDaoFactory implements AbstractSingerDaoFactory {
    @Override
    public SingerFileDao createSingerDao(List<Singer> singers) {
        System.out.println("stub start");
        System.out.println("stub finish");
        return new SingerFileDao(singers);
    }
}