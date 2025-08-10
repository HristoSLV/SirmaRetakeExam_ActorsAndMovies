package com.sirmascademy.SirmaRetakeExam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieRequestDto {

    @Size(min = 2, max = 80)
    private String title;

    @NotBlank(message = "Release date is required")
    private LocalDate releaseDate;

}
