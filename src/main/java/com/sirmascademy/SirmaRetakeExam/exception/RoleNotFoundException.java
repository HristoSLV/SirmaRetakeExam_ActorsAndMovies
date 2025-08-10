package com.sirmascademy.SirmaRetakeExam.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(Long id) {
        super("Role with id " + id + " not found");
    }

}
