package com.company.restaurantemployeeservice.exception;

public class EmployeeMovementAlreadyExistsException extends RuntimeException {
    public EmployeeMovementAlreadyExistsException(String msg) {
        super(msg);
    }
}
