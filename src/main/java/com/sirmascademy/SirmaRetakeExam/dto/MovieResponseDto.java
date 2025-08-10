package com.sirmascademy.SirmaRetakeExam.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieResponseDto {

    private Long id;

    private String title;

    private LocalDate releaseDate;

}
