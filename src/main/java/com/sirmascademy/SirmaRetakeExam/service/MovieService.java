package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.MovieRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.MovieResponseDto;
import com.sirmascademy.SirmaRetakeExam.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieResponseDto createMovie(@Valid MovieRequestDto movieRequestDto) {
    }

    public List<MovieResponseDto> getAllMovies() {
    }

    public MovieResponseDto getMovieById(Long id) {
    }

    public MovieResponseDto deleteMovie(Long id) {
    }

    public MovieResponseDto updateMovie(@Valid Long id, MovieRequestDto movieRequestDto) {
    }
}
