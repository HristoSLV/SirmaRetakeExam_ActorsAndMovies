package com.sirmascademy.SirmaRetakeExam.mapper;

import com.sirmascademy.SirmaRetakeExam.dto.MovieResponseDto;
import com.sirmascademy.SirmaRetakeExam.model.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public static MovieResponseDto toMovieDto(MovieEntity movieEntity) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();

        movieResponseDto.setId(movieEntity.getId());
        movieResponseDto.setTitle(movieEntity.getTitle());
        movieResponseDto.setReleaseDate(movieEntity.getReleaseDate());

        return movieResponseDto;
    }

}
