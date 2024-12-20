package com.example.demo;

import com.example.demo.dbClasses.Singerdb;
import com.example.demo.dbClasses.Singerhibernate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerhibernateRepository extends JpaRepository<Singerhibernate, Integer> {
    Page<Singerhibernate> findAll(Pageable pageable);
}
