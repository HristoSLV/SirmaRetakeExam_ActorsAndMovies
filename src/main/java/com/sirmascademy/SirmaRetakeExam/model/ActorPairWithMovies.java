package com.sirmascademy.SirmaRetakeExam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorPairWithMovies {

    private ActorPair actorPair;

    private int movieCount;

    private List<MovieEntity> listOfMovies;

    @Override
    public String toString() {
        return "ActorPairWithMovies{" +
                "actorPair=" + actorPair +
                ", movieCount=" + movieCount +
                ", listOfMovies=" + listOfMovies +
                '}';
    }

}
