package com.sirmascademy.SirmaRetakeExam.service;

import com.sirmascademy.SirmaRetakeExam.dto.ActorRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.MovieRequestDto;
import com.sirmascademy.SirmaRetakeExam.dto.RoleRequestDto;
import com.sirmascademy.SirmaRetakeExam.util.DateTimeFormatterUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class CsvImportService {

    private static final String ACTOR_FILE = "/taskFiles/actors.csv";
    private static final String MOVIE_FILE = "/taskFiles/movies.csv";
    private static final String ROLE_FILE = "/taskFiles/roles.csv";


    private final ActorService actorService;
    private final MovieService movieService;
    private final RoleService roleService;


    public CsvImportService(ActorService actorService, MovieService movieService, RoleService roleService) {
        this.actorService = actorService;
        this.movieService = movieService;
        this.roleService = roleService;
    }

    public void importActors() {

        List<DateTimeFormatter> dateFormat = DateTimeFormatterUtil.detectDateFormat(ACTOR_FILE, 2);

        try (InputStream inputStream = getClass().getResourceAsStream(ACTOR_FILE);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {

            String line;
            boolean isFirstRow = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Invalid row in actors file. Wrong number of columns on row:  " + line);
                    continue;
                }

                try {
                    String fullName = parts[1].trim();
                    LocalDate birthDate = DateTimeFormatterUtil.parseDateFromFormat(parts[2].trim(), dateFormat);

                    if (fullName.length() < 2 || fullName.length() > 80) {
                        System.err.println("Invalid full name in actors file: " + fullName + " on row: " + line);
                        continue;
                    }

                    ActorRequestDto actorRequestDto = new ActorRequestDto();
                    actorRequestDto.setFullName(fullName);
                    actorRequestDto.setBirthDate(birthDate);

                    actorService.createActor(actorRequestDto);

                } catch (Exception e) {
                    System.err.println("Invalid data format in actors file on row: " + line);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Actors File not found" + e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading actors file" + e);
        }

        System.out.println("Actors imported");
    }

    public void importMovies() {

        List<DateTimeFormatter> dateFormat = DateTimeFormatterUtil.detectDateFormat(MOVIE_FILE, 2);

        try (InputStream inputStream = getClass().getResourceAsStream(MOVIE_FILE);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {

            String line;
            boolean isFirstRow = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Invalid row in movies file. Wrong number of columns on row:  " + line);
                    continue;
                }


                try {
                    String title = parts[1].trim();
                    LocalDate releaseDate = DateTimeFormatterUtil.parseDateFromFormat(parts[2].trim(), dateFormat);

                    if (title.length() < 2 || title.length() > 80) {
                        System.err.println("Invalid title in movies file: " + title + " on row: " + line);
                        continue;
                    }

                    MovieRequestDto movieRequestDto = new MovieRequestDto();
                    movieRequestDto.setTitle(title);
                    movieRequestDto.setReleaseDate(releaseDate);

                    movieService.createMovie(movieRequestDto);

                } catch (Exception e) {
                    System.err.println("Invalid data format in movies file on row: " + line);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Movies File not found" + e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading movies file" + e);
        }

        System.out.println("Movies imported");
    }

    public void importRoles() {
        try (InputStream inputStream = getClass().getResourceAsStream(ROLE_FILE);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {

            String line;
            boolean isFirstRow = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Invalid row in roles file. Wrong number of columns on row:  " + line);
                    continue;
                }

                try {
                    if (!isValidId(parts[1])) {
                        System.err.println("Invalid actor id in roles file: " + parts[1] + " on row: " + line);
                        continue;
                    }

                    if (!isValidId(parts[2])) {
                        System.err.println("Invalid movie id in roles file: " + parts[2] + " on row: " + line);
                        continue;
                    }

                    Long actorId = Long.parseLong(parts[1].trim());
                    Long movieId = Long.parseLong(parts[2].trim());
                    String roleName = parts[3].trim();

                    if (roleName.length() > 80) {
                        System.err.println("Invalid role name in roles file: " + parts[3] + " on row: " + line);
                        continue;
                    }

                    RoleRequestDto roleRequestDto = new RoleRequestDto();
                    roleRequestDto.setActorId(actorId);
                    roleRequestDto.setMovieId(movieId);
                    roleRequestDto.setRoleName(roleName);

                    roleService.createRole(roleRequestDto);

                } catch (Exception e) {
                    System.err.println("Invalid data format in roles file on row: " + line);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Roles File not found" + e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading roles file" + e);
        }

        System.out.println("Roles imported");
    }

    private static boolean isValidId(String string) {
        if (string == null || string.isBlank()) {
            return false;
        }

        if (string.length() == 1 && string.charAt(0) == '-') {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
