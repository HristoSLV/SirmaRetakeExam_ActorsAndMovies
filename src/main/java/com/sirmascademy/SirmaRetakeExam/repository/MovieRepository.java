package com.sirmascademy.SirmaRetakeExam.repository;

import com.sirmascademy.SirmaRetakeExam.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
