package com.sirmascademy.SirmaRetakeExam.mapper;

import com.sirmascademy.SirmaRetakeExam.dto.ActorResponseDto;
import com.sirmascademy.SirmaRetakeExam.model.ActorEntity;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    public static ActorResponseDto toActorDto(ActorEntity actorEntity) {
        ActorResponseDto actorResponseDto = new ActorResponseDto();

        actorResponseDto.setId(actorEntity.getId());
        actorResponseDto.setFullName(actorEntity.getFullName());
        actorResponseDto.setBirthDate(actorEntity.getBirthDate());

        return actorResponseDto;
    }

}
