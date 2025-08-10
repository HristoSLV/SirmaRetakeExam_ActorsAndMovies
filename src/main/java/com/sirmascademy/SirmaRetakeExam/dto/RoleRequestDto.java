package com.sirmascademy.SirmaRetakeExam.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RoleRequestDto {

    @Min(value = 1, message = "Actor ID cannot be less than 1")
    private Long actorId;

    @Min(value = 1, message = "Movie ID cannot be less than 1")
    private Long movieId;

    private String roleName;

}
