package com.jump_java.jump_java.controller;

import com.jump_java.jump_java.dto.AnimalDto;
import com.jump_java.jump_java.dto.AnimalWithDetailsDto;
import com.jump_java.jump_java.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private  AnimalService animalService;


    @PostMapping
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody @Valid AnimalDto animalDto) {
        return ResponseEntity.ok(animalService.addAnimal(animalDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAnimal(@PathVariable Long id) {
        animalService.removeAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimal(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.getAnimal(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable Long id, @RequestBody @Valid AnimalDto animalDto) {
        return ResponseEntity.ok(animalService.updateAnimal(id, animalDto));
    }

    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAnimals() {
        return ResponseEntity.ok(animalService.getAnimals());
    }

    @GetMapping("/details")
    public ResponseEntity<List<AnimalWithDetailsDto>> getAnimalsWithDetails() {
        return ResponseEntity.ok(animalService.getAnimalsWithDetails());
    }
}
