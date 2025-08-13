package com.sirmascademy.SirmaRetakeExam.controller;

import com.sirmascademy.SirmaRetakeExam.model.ActorPairWithMovies;
import com.sirmascademy.SirmaRetakeExam.service.ActorPairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor-pair")
public class ActorPairController {

    private final ActorPairService actorPairService;

    public ActorPairController(ActorPairService actorPairService) {
        this.actorPairService = actorPairService;
    }

    @GetMapping("/actor-pair")
    public ResponseEntity<ActorPairWithMovies> findPairWithMostMoviesTogether() {
        return new ResponseEntity<>(actorPairService.findPairWithMostMoviesTogether(), HttpStatus.OK);
    }

    @GetMapping("/actor-pair-list")
    public ResponseEntity<List<ActorPairWithMovies>> findPairWithMostMoviesTogetherList() {
        return new ResponseEntity<>(actorPairService.findPairsWithMostMoviesTogetherList(), HttpStatus.OK);
    }

}
