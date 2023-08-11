package com.company.restaurantemployeeservice.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String msg) {
        super(msg);
    }
}
