package com.jump_java.jump_java.model;

import com.jump_java.jump_java.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;
}
