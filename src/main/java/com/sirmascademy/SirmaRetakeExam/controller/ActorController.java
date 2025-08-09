package com.sirmascademy.SirmaRetakeExam.controller;

import com.sirmascademy.SirmaRetakeExam.model.Actor;
import com.sirmascademy.SirmaRetakeExam.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(Actor actor) {
        Actor createdActor = actorService.createActor(actor);
        return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getAllActors();
        return new ResponseEntity<>(actors,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(Long id, Actor actor) {
        Actor updatedActor = actorService.updateActor(id, actor);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> deleteActor(Long id) {
        Actor deletedActor = actorService.deleteActor(id);
        return new ResponseEntity<>(deletedActor, HttpStatus.NO_CONTENT);
    }

}
