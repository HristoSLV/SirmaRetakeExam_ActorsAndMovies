package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.model.ActorEntity;
import com.sirmascademy.SirmaRetakeExam.model.ActorPair;
import com.sirmascademy.SirmaRetakeExam.model.ActorPairWithMovies;
import com.sirmascademy.SirmaRetakeExam.model.MovieEntity;
import com.sirmascademy.SirmaRetakeExam.model.RoleEntity;
import com.sirmascademy.SirmaRetakeExam.repository.ActorRepository;
import com.sirmascademy.SirmaRetakeExam.repository.MovieRepository;
import com.sirmascademy.SirmaRetakeExam.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActorPairService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final RoleRepository roleRepository;

    public ActorPairService(ActorRepository actorRepository, MovieRepository movieRepository, RoleRepository roleRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.roleRepository = roleRepository;
    }

    public ActorPairWithMovies findPairWithMostMoviesTogether() {
        List<RoleEntity> allRoles = roleRepository.findAll();

        Map<Long, ActorEntity> actorsMap = actorRepository.findAll().stream()
                .collect(Collectors.toMap(ActorEntity::getId, actor -> actor));

        Map<Long, MovieEntity> moviesMap = movieRepository.findAll().stream()
                .collect(Collectors.toMap(MovieEntity::getId, movie -> movie));


        Map<ActorPair, List<MovieEntity>> pairToMovies = new HashMap<>();

        Map<Long, List<RoleEntity>> rolesByMovie = allRoles.stream()
                .collect(Collectors.groupingBy(RoleEntity::getMovieId));


        for (List<RoleEntity> rolesInMovie : rolesByMovie.values()) {
            List<Long> actorIds = rolesInMovie.stream()
                    .map(RoleEntity::getActorId)
                    .distinct()
                    .toList();

            if (actorIds.size() < 2) {
                continue;
            }

            for (int i = 0; i < actorIds.size() - 1; i++) {
                for (int j = i + 1; j < actorIds.size(); j++) {
                    ActorEntity actorOne = actorsMap.get(actorIds.get(i));
                    ActorEntity actorTwo = actorsMap.get(actorIds.get(j));

                    ActorPair pair = new ActorPair(actorOne, actorTwo);

                    pairToMovies.computeIfAbsent(pair, _ -> new ArrayList<>())
                            .add(moviesMap.get(rolesInMovie.getFirst().getMovieId()));
                }
            }
        }

        return pairToMovies.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .map(entry -> new ActorPairWithMovies(entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue()))
                .orElse(null);
    }

    public List<ActorPairWithMovies> findPairsWithMostMoviesTogetherList() {
        List<RoleEntity> allRoles = roleRepository.findAll();

        Map<Long, ActorEntity> actorsMap = actorRepository.findAll().stream()
                .collect(Collectors.toMap(ActorEntity::getId, a -> a));

        Map<Long, MovieEntity> moviesMap = movieRepository.findAll().stream()
                .collect(Collectors.toMap(MovieEntity::getId, m -> m));


        Map<ActorPair, List<MovieEntity>> pairToMovies = new HashMap<>();

        Map<Long, List<RoleEntity>> rolesByMovie = allRoles.stream()
                .collect(Collectors.groupingBy(RoleEntity::getMovieId));


        for (List<RoleEntity> rolesInMovie : rolesByMovie.values()) {
            List<Long> actorIds = rolesInMovie.stream()
                    .map(RoleEntity::getActorId)
                    .distinct()
                    .toList();

            if (actorIds.size() < 2) {
                continue;
            }

            for (int i = 0; i < actorIds.size() - 1; i++) {
                for (int j = i + 1; j < actorIds.size(); j++) {
                    ActorEntity actor1 = actorsMap.get(actorIds.get(i));
                    ActorEntity actor2 = actorsMap.get(actorIds.get(j));
                    ActorPair pair = new ActorPair(actor1, actor2);

                    pairToMovies.computeIfAbsent(pair, _ -> new ArrayList<>())
                            .add(moviesMap.get(rolesInMovie.getFirst().getMovieId()));
                }
            }
        }

        int maxMoviesTogether = pairToMovies.values().stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);

        return pairToMovies.entrySet().stream()
                .filter(entry -> entry.getValue().size() == maxMoviesTogether)
                .map(entry -> new ActorPairWithMovies(entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

}