package com.sirmascademy.SirmaRetakeExam.exception;

public class RoleImportException extends RuntimeException {

    public RoleImportException(String message) {
        super(message);
    }

    public RoleImportException(String message, Throwable cause) {
        super(message, cause);
    }

}