package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.model.Actor;
import com.sirmascademy.SirmaRetakeExam.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
    }

    public Actor createActor(Actor actor) {
    }

    public Actor deleteActor(Long id) {
    }

    public Actor updateActor(Long id, Actor actor) {
    }
}
