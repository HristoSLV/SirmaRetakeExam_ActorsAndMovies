package com.sirmascademy.SirmaRetakeExam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ActorPair {

    private ActorEntity actor1;

    private ActorEntity actor2;

    public ActorPair(ActorEntity actor1, ActorEntity actor2) {
        if (actor1.getId() < actor2.getId()) {
            this.actor1 = actor1;
            this.actor2 = actor2;
        } else {
            this.actor1 = actor2;
            this.actor2 = actor1;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActorPair)) return false;
        ActorPair that = (ActorPair) o;
        return Objects.equals(actor1.getId(), that.actor1.getId()) &&
                Objects.equals(actor2.getId(), that.actor2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor1.getId(), actor2.getId());
    }

    @Override
    public String toString() {
        return "ActorPair{" +
                "actor1=" + actor1.getId() +
                ", actor2=" + actor2.getId() +
                '}';
    }

}
