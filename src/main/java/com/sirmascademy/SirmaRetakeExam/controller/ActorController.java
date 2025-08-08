package com.sirmascademy.SirmaRetakeExam.controller;

import com.sirmascademy.SirmaRetakeExam.service.ActorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
}
