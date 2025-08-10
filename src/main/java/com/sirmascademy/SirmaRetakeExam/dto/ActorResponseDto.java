package com.sirmascademy.SirmaRetakeExam.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActorResponseDto {

    private Long id;

    private String fullName;

    private LocalDate birthDate;
}
