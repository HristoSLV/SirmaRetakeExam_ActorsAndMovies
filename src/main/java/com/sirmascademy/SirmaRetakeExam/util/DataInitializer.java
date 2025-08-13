package com.sirmascademy.SirmaRetakeExam.util;

import com.sirmascademy.SirmaRetakeExam.repository.ActorRepository;
import com.sirmascademy.SirmaRetakeExam.repository.MovieRepository;
import com.sirmascademy.SirmaRetakeExam.repository.RoleRepository;
import com.sirmascademy.SirmaRetakeExam.service.CsvImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final RoleRepository roleRepository;
    private final CsvImportService csvImportService;

    public DataInitializer(ActorRepository actorRepository, MovieRepository movieRepository,
                           RoleRepository roleRepository, CsvImportService csvImportService) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.roleRepository = roleRepository;
        this.csvImportService = csvImportService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (actorRepository.findAll().isEmpty()) {
            csvImportService.importActors();
        }

        if (movieRepository.findAll().isEmpty()) {
            csvImportService.importMovies();
        }

        if (roleRepository.findAll().isEmpty()) {
            csvImportService.importRoles();
        }

    }

}
