package com.sirmascademy.SirmaRetakeExam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ActorPair {

    private ActorEntity actorOne;

    private ActorEntity actorTwo;

    public ActorPair(ActorEntity actorOne, ActorEntity actorTwo) {
        if (actorOne.getId() < actorTwo.getId()) {
            this.actorOne = actorOne;
            this.actorTwo = actorTwo;
        } else {
            this.actorOne = actorTwo;
            this.actorTwo = actorOne;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActorPair)) {
            return false;
        }
        ActorPair that = (ActorPair) o;
        return Objects.equals(actorOne.getId(), that.actorOne.getId()) &&
                Objects.equals(actorTwo.getId(), that.actorTwo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorOne.getId(), actorTwo.getId());
    }

    @Override
    public String toString() {
        return "ActorPair{" +
                "actor1=" + actorOne.getId() +
                ", actor2=" + actorTwo.getId() +
                '}';
    }

}
