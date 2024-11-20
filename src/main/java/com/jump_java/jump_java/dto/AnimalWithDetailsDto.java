package com.jump_java.jump_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalWithDetailsDto {
    private Long id;
    private String name;
    private int age;
    private String breedName;
    private String gender;

}

