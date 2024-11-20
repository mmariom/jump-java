package com.jump_java.jump_java.repository;

import com.jump_java.jump_java.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

