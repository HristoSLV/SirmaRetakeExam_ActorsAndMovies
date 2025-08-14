package com.sirmascademy.SirmaRetakeExam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long actorId;

    private Long movieId;

    private String roleName;


    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", actorId=" + actorId +
                ", movieId=" + movieId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}
