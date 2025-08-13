package com.sirmascademy.SirmaRetakeExam.exception;

public class MovieImportException extends RuntimeException {

    public MovieImportException(String message) {
        super(message);
    }

    public MovieImportException(String message, Throwable cause) {
        super(message, cause);
    }

}
