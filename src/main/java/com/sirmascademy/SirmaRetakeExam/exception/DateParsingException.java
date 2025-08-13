package com.sirmascademy.SirmaRetakeExam.exception;

public class DateParsingException extends RuntimeException {

    public DateParsingException(String message) {
        super(message);
    }

    public DateParsingException(String message, Throwable cause) {
        super(message, cause);
    }

}