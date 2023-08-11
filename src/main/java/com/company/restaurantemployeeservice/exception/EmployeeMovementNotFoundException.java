package com.company.restaurantemployeeservice.exception;

public class EmployeeMovementNotFoundException extends RuntimeException{
    public EmployeeMovementNotFoundException(String msg) {
        super(msg);
    }
}
