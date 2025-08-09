package com.sirmascademy.SirmaRetakeExam.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActorRequestDto {

    private String fullName;

    private LocalDate birthDate;
}
