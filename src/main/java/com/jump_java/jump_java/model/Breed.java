package com.jump_java.jump_java.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

}
