package com.company.restaurantemployeeservice.controller;

import com.company.restaurantemployeeservice.entity.EmployeeMovement;
import com.company.restaurantemployeeservice.exception.EmployeeMovementAlreadyExistsException;
import com.company.restaurantemployeeservice.exception.EmployeeMovementNotFoundException;
import com.company.restaurantemployeeservice.service.EmployeeMovementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api/v1/employeemovements")
@AllArgsConstructor
public class EmployeeMovementController {

    private final EmployeeMovementService employeeMovementService;

    @GetMapping
    public ResponseEntity<List<EmployeeMovement>> getEmployeeMovements(){
        return new ResponseEntity<>(employeeMovementService.getEmployeeMovements(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeMovement> getEmployeeMovement(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeMovementService.getEmployeeMovementById(id), OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeMovement> createEmployeeMovement(@RequestBody EmployeeMovement newEmployeeMovement){
        return new ResponseEntity<>(employeeMovementService.createEmployeeMovement(newEmployeeMovement), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeMovement(@PathVariable Integer id){
        employeeMovementService.deleteEmployeeMovement(id);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployeeMovement(@PathVariable Integer id, @RequestBody EmployeeMovement newEmployeeMovement){
        employeeMovementService.updateEmployeeMovement(id,newEmployeeMovement);
        return new ResponseEntity<>(OK);
    }








    @ExceptionHandler(EmployeeMovementNotFoundException.class)
    public ResponseEntity<String> handleRegionNotFoundException(EmployeeMovementNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(EmployeeMovementAlreadyExistsException.class)
    public ResponseEntity<String> handleRegionAlreadyExistsException(EmployeeMovementAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), CONFLICT);
    }
}
