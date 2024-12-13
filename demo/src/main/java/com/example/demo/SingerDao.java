package com.example.demo;
import com.example.demo.realClasses.Singer;

import java.util.List;

public interface SingerDao {
    public List<Singer> findSingers() throws InterruptedException;
    public void saveSingers(List<Singer> singers) throws InterruptedException;
    public void SetList(List<Singer> singers);
}
