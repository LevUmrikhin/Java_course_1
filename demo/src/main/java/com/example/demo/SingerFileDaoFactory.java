package com.example.demo;

import com.example.demo.realClasses.Singer;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class SingerFileDaoFactory implements AbstractSingerDaoFactory {
    @Override
    public SingerFileDao createSingerDao(List<Singer> singers) {
        System.out.println("stub start");
        System.out.println("stub finish");
        SingerFileDao dao = new SingerFileDao();
        dao.SetList(singers);
        return dao;
    }
}