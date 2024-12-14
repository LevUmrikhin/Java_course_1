package com.example.demo;

import com.example.demo.realClasses.Singer;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class SingerJdbcDaoFactory implements AbstractSingerDaoFactory {
    @Override
    public SingerDao createSingerDao(List<Singer> singers) {
        System.out.println("stub start");
        System.out.println("stub finish");
        SingerJdbcDao dao = new SingerJdbcDao();
        dao.SetList(singers);
        return dao;
    }
}