package com.sirmascademy.SirmaRetakeExam.repository;

import com.sirmascademy.SirmaRetakeExam.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
