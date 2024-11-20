package com.jump_java.jump_java.service;

import com.jump_java.jump_java.dto.AnimalDto;
import com.jump_java.jump_java.dto.AnimalWithDetailsDto;
import com.jump_java.jump_java.enums.Gender;
import com.jump_java.jump_java.model.Animal;
import com.jump_java.jump_java.model.Breed;
import com.jump_java.jump_java.repository.AnimalRepository;
import com.jump_java.jump_java.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private  AnimalRepository animalRepository;
    @Autowired
    private  BreedRepository breedRepository;


    public AnimalDto addAnimal(AnimalDto animalDto) {
        Breed breed = breedRepository.findById(animalDto.getBreedId())
                .orElseThrow(() -> new IllegalArgumentException("Breed not found"));

        Animal animal = new Animal();
        animal.setName(animalDto.getName());
        animal.setAge(animalDto.getAge());
        animal.setGender(Gender.valueOf(animalDto.getGender().toUpperCase()));
        animal.setBreed(breed);

        Animal savedAnimal = animalRepository.save(animal);

        return mapToAnimalDto(savedAnimal);
    }

    public void removeAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal not found");
        }
        animalRepository.deleteById(id);
    }

    public AnimalDto getAnimal(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not found"));
        return mapToAnimalDto(animal);
    }

    public AnimalDto updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not found"));

        Breed breed = breedRepository.findById(animalDto.getBreedId())
                .orElseThrow(() -> new IllegalArgumentException("Breed not found"));

        animal.setName(animalDto.getName());
        animal.setAge(animalDto.getAge());
        animal.setGender(Gender.valueOf(animalDto.getGender().toUpperCase()));
        animal.setBreed(breed);

        Animal updatedAnimal = animalRepository.save(animal);

        return mapToAnimalDto(updatedAnimal);
    }

    public List<AnimalDto> getAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream().map(this::mapToAnimalDto).toList();
    }

    public List<AnimalWithDetailsDto> getAnimalsWithDetails() {
        List<Animal> animals = animalRepository.findAll();
//        return animals.stream().map(this::mapToAnimalWithDetailsDto).toList();
        return animals.stream().map(animal -> mapToAnimalWithDetailsDto(animal)).toList();
    }

    private AnimalDto mapToAnimalDto(Animal animal) {
        return new AnimalDto(
                animal.getId(),
                animal.getName(),
                animal.getAge(),
                animal.getBreed().getId(),
                animal.getGender().name()
        );
    }

    private AnimalWithDetailsDto mapToAnimalWithDetailsDto(Animal animal) {
        return new AnimalWithDetailsDto(
                animal.getId(),
                animal.getName(),
                animal.getAge(),
                animal.getBreed().getName(),
                animal.getGender().name()
        );
    }
}

