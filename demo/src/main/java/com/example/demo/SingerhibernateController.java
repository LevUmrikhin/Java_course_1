package com.example.demo;

import com.example.demo.dbClasses.Singerhibernate;
import com.example.demo.dbClasses.Singerhibernate;
import com.example.demo.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/singers")
public class SingerhibernateController {

    @Autowired
    private SingerService singerhibernateService;

    // Получение всех исполнителей
    @GetMapping("/all")
    public List<Singerhibernate> getAllSingers() {
        return singerhibernateService.getAllSingers();
    }

    // Получение исполнителей постранично
    @GetMapping("/page")
    public Page<Singerhibernate> getSingersByPage(@RequestParam int page, @RequestParam int size) {
        return singerhibernateService.getSingersByPage(page, size);
    }

    // Получение исполнителя по id
    @GetMapping("/{id}")
    public ResponseEntity<Singerhibernate> getSingerById(@PathVariable int id) {
        Optional<Singerhibernate> singer = singerhibernateService.getSingerById(id);
        return singer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Создание исполнителя
    @PostMapping
    public ResponseEntity<Singerhibernate> createSinger(@RequestBody Singerhibernate singer) {
        Singerhibernate createdSinger = singerhibernateService.createSinger(singer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSinger);
    }

    // Замена исполнителя по id
    @PutMapping("/{id}")
    public ResponseEntity<Singerhibernate> updateSinger(@PathVariable int id, @RequestBody Singerhibernate singerDetails) {
        Singerhibernate updatedSinger = singerhibernateService.updateSinger(id, singerDetails);
        return ResponseEntity.ok(updatedSinger);
    }

    // Удаление исполнителя по id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinger(@PathVariable int id) {
        singerhibernateService.deleteSinger(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
