package com.company.restaurantemployeeservice.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
