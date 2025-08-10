package com.sirmascademy.SirmaRetakeExam.exception;

public class MovieNotFoundException extends APIException {

    public MovieNotFoundException(Long id) {
        super("Movie with id " + id + " not found");
    }

}
