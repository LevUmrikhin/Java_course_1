

package com.example.demo;

import com.example.demo.realClasses.Singer;
import com.example.demo.realClasses.Album;
import com.example.demo.realClasses.Song;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component
public class SingerDaoFactory {
    @Value("${data.singer.factory.type}")
    private String factoryType;
     @PostConstruct
    public void init() {
        System.out.println("factoryType: " + factoryType);
        
    }
    private final SingerFileDao singerFileDao;
    private final SingerJdbcDao singerJdbcDao;

    public SingerDaoFactory(SingerFileDao singerFileDao, SingerJdbcDao singerJdbcDao) {
        this.singerFileDao = singerFileDao;
        this.singerJdbcDao = singerJdbcDao;
        this.factoryType = factoryType;
    }
    
    public void SetList(List<Singer> list1){
        this.singerFileDao.SetList(list1);
        this.singerJdbcDao.SetList(list1);
    }
    public SingerDao getDao() {
        switch(factoryType){
            case "file":
            return singerFileDao;
            case "database":
            return singerJdbcDao;
            default:
            throw new ArithmeticException("factorytype");
        }

    }
    
}
