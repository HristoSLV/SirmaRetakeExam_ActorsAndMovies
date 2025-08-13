package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.MovieRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.MovieResponseDto;
import com.sirmascademy.SirmaRetakeExam.exception.MovieNotFoundException;
import com.sirmascademy.SirmaRetakeExam.mapper.MovieMapper;
import com.sirmascademy.SirmaRetakeExam.model.MovieEntity;
import com.sirmascademy.SirmaRetakeExam.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public MovieResponseDto createMovie(MovieRequestDto movieRequestDto) {
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setTitle(movieRequestDto.getTitle());
        movieEntity.setReleaseDate(movieRequestDto.getReleaseDate());

        movieRepository.save(movieEntity);
        return MovieMapper.toMovieDto(movieEntity);
    }

    public List<MovieResponseDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(MovieMapper::toMovieDto)
                .toList();
    }

    public MovieResponseDto getMovieById(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));

        return MovieMapper.toMovieDto(movieEntity);
    }

    public MovieResponseDto updateMovie(Long id, MovieRequestDto movieRequestDto) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));

        movieEntity.setTitle(movieRequestDto.getTitle());
        movieEntity.setReleaseDate(movieRequestDto.getReleaseDate());

        movieRepository.save(movieEntity);
        return MovieMapper.toMovieDto(movieEntity);
    }

    public MovieResponseDto deleteMovie(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));

        movieRepository.delete(movieEntity);
        return MovieMapper.toMovieDto(movieEntity);
    }

}
