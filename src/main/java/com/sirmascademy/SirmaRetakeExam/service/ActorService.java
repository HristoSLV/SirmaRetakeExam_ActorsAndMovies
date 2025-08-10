package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.ActorRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.ActorResponseDto;
import com.sirmascademy.SirmaRetakeExam.model.Actor;
import com.sirmascademy.SirmaRetakeExam.repository.ActorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    public ActorResponseDto createActor(@Valid ActorRequestDto actor) {
    }

    public List<ActorResponseDto> getAllActors() {
    }

    public ActorResponseDto updateActor(Long id, ActorRequestDto actor) {
    }

    public ActorResponseDto deleteActor(Long id) {
    }

    public ActorResponseDto getActorById(Long id) {
    }
}
