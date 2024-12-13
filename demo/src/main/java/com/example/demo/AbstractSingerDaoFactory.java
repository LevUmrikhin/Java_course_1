package com.example.demo;

import com.example.demo.realClasses.Singer;

import java.util.List;

public interface AbstractSingerDaoFactory {
    public SingerDao createSingerDao(List<Singer> singers) throws InterruptedException;
}
