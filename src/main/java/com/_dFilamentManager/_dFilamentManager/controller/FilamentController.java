package com._dFilamentManager._dFilamentManager.controller;

import com._dFilamentManager._dFilamentManager.entity.Filament;
import com._dFilamentManager._dFilamentManager.service.FilamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filaments")
public class FilamentController {

    @Autowired
    private FilamentService filamentService;

    @GetMapping
    public ResponseEntity<List<Filament>> getAllFilaments() {
        List<Filament> filaments = filamentService.getAll();
        return new ResponseEntity<>(filaments, HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Filament>> getAllFilamentsPaged(@RequestParam int page, @RequestParam int size) {
        Page<Filament> filaments = filamentService.getAllPaged(page, size);
        return new ResponseEntity<>(filaments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filament> getFilamentById(@PathVariable Long id) {
        Filament filament = filamentService.getById(id);
        return new ResponseEntity<>(filament, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Filament> getFilamentByName(@PathVariable String name) {
        Filament filament = filamentService.getByName(name);
        return new ResponseEntity<>(filament, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Filament> createFilament(@RequestBody Filament filament) {
        Filament createdFilament = filamentService.save(filament);
        return new ResponseEntity<>(createdFilament, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filament> updateFilament(@PathVariable Long id, @RequestBody Filament updatedFilament) {
        Filament filament = filamentService.update(id, updatedFilament);
        return new ResponseEntity<>(filament, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilament(@PathVariable Long id) {
        filamentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
