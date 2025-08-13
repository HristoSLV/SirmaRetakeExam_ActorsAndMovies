package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.ActorRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.ActorResponseDto;
import com.sirmascademy.SirmaRetakeExam.exception.ActorNotFoundException;
import com.sirmascademy.SirmaRetakeExam.mapper.ActorMapper;
import com.sirmascademy.SirmaRetakeExam.model.ActorEntity;
import com.sirmascademy.SirmaRetakeExam.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    public ActorResponseDto createActor(ActorRequestDto actorRequestDto) {
        ActorEntity actorEntity = new ActorEntity();

        actorEntity.setFullName(actorRequestDto.getFullName());
        actorEntity.setBirthDate(actorRequestDto.getBirthDate());

        ActorEntity savedActorEntity = actorRepository.save(actorEntity);
        return ActorMapper.toActorDto(savedActorEntity);
    }

    public List<ActorResponseDto> getAllActors() {
        return actorRepository.findAll().stream()
                .map(ActorMapper::toActorDto)
                .toList();
    }

    public ActorResponseDto getActorById(Long id) {
        ActorEntity actorEntity = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));

        return ActorMapper.toActorDto(actorEntity);
    }

    public ActorResponseDto updateActor(Long id, ActorRequestDto actorRequestDto) {
        ActorEntity actorEntity = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));

        actorEntity.setFullName(actorRequestDto.getFullName());
        actorEntity.setBirthDate(actorRequestDto.getBirthDate());

        ActorEntity updatedActorEntity = actorRepository.save(actorEntity);
        return ActorMapper.toActorDto(updatedActorEntity);
    }

    public ActorResponseDto deleteActor(Long id) {
        ActorEntity actorEntity = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));

        actorRepository.delete(actorEntity);
        return ActorMapper.toActorDto(actorEntity);
    }

}
