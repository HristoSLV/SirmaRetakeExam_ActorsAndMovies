package com.sirmascademy.SirmaRetakeExam.controller;

import com.sirmascademy.SirmaRetakeExam.dto.ActorRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.ActorResponseDto;
import com.sirmascademy.SirmaRetakeExam.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<ActorResponseDto> createActor(@Valid @RequestBody ActorRequestDto actorRequestDto) {
        ActorResponseDto createdActor = actorService.createActor(actorRequestDto);
        return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActorResponseDto>> getAllActors() {
        List<ActorResponseDto> actors = actorService.getAllActors();
        return new ResponseEntity<>(actors,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorResponseDto> getActorById(@PathVariable("id") Long id) {
        ActorResponseDto actor = actorService.getActorById(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorResponseDto> updateActor(@Valid @PathVariable("id") Long id, @RequestBody ActorRequestDto actorRequestDto) {
        ActorResponseDto updatedActor = actorService.updateActor(id, actorRequestDto);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ActorResponseDto> deleteActor(@PathVariable("id") Long id) {
        ActorResponseDto deletedActor = actorService.deleteActor(id);
        return new ResponseEntity<>(deletedActor, HttpStatus.NO_CONTENT);
    }

}
