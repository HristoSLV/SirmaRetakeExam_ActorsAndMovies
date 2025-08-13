package com.sirmascademy.SirmaRetakeExam.exception;

public class DateFormatDetectionException extends RuntimeException {

    public DateFormatDetectionException(String message) {
        super(message);
    }

    public DateFormatDetectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
