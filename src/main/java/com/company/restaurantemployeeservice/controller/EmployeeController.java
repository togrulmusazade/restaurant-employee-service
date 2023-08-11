package com.company.restaurantemployeeservice.controller;

import com.company.restaurantemployeeservice.entity.Employee;
import com.company.restaurantemployeeservice.exception.EmployeeAlreadyExistsException;
import com.company.restaurantemployeeservice.exception.EmployeeNotFoundException;
import com.company.restaurantemployeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String username){
        return new ResponseEntity<>(employeeService.getEmployees(username), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee){
        return new ResponseEntity<>(employeeService.createEmployee(newEmployee), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Integer id, @RequestBody Employee newEmployee){
        employeeService.updateEmployee(id,newEmployee);
        return new ResponseEntity<>(OK);
    }








    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleRegionNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handleRegionAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), CONFLICT);
    }

}
