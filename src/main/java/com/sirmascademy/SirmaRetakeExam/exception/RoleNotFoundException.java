package com.sirmascademy.SirmaRetakeExam.exception;

public class RoleNotFoundException extends APIException {

    public RoleNotFoundException(Long id) {
        super("Role with id " + id + " not found");
    }

}
