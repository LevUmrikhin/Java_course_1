package com.example.demo;

import com.example.demo.dbClasses.Singerdb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerdbRepository extends JpaRepository<Singerdb, Integer> {
    Page<Singerdb> findAll(Pageable pageable);
}
