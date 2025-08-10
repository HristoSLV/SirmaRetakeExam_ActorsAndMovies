package com.sirmascademy.SirmaRetakeExam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ActorRequestDto {

    @Size(min = 2, max = 80)
    private String fullName;

    @NotBlank(message = "Birth date is required")
    private LocalDate birthDate;
}
