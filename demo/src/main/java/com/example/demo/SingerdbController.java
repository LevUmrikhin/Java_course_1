package com.example.demo;

import com.example.demo.dbClasses.Singerdb;
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
public class SingerdbController {

    @Autowired
    private SingerService singerdbService;

    // Получение всех исполнителей
    @GetMapping
    public List<Singerdb> getAllSingers() {
        return singerdbService.getAllSingers();
    }

    // Получение исполнителей постранично
    @GetMapping("/page")
    public Page<Singerdb> getSingersByPage(@RequestParam int page, @RequestParam int size) {
        return singerdbService.getSingersByPage(page, size);
    }

    // Получение исполнителя по id
    @GetMapping("/{id}")
    public ResponseEntity<Singerdb> getSingerById(@PathVariable int id) {
        Optional<Singerdb> singer = singerdbService.getSingerById(id);
        return singer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Создание исполнителя
    @PostMapping
    public ResponseEntity<Singerdb> createSinger(@RequestBody Singerdb singer) {
        Singerdb createdSinger = singerdbService.createSinger(singer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSinger);
    }

    // Замена исполнителя по id
    @PutMapping("/{id}")
    public ResponseEntity<Singerdb> updateSinger(@PathVariable int id, @RequestBody Singerdb singerDetails) {
        Singerdb updatedSinger = singerdbService.updateSinger(id, singerDetails);
        return ResponseEntity.ok(updatedSinger);
    }

    // Удаление исполнителя по id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinger(@PathVariable int id) {
        singerdbService.deleteSinger(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
