package com.jump_java.jump_java.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {

    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    private int age;

    @NotNull
    private Long breedId;

    @NotBlank
    private String gender;
}
