package com.company.restaurantemployeeservice.service;

import com.company.restaurantemployeeservice.entity.Employee;
import com.company.restaurantemployeeservice.exception.EmployeeAlreadyExistsException;
import com.company.restaurantemployeeservice.exception.EmployeeNotFoundException;
import com.company.restaurantemployeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;

    public List<Employee> getEmployees(String username){
        if(username==null){
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findAllByusername(username);
        }
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee newEmployee) {
        Optional<Employee> employeeByName = employeeRepository.findByName(newEmployee.getName());
        if (employeeByName.isPresent()){
            throw new EmployeeAlreadyExistsException("Employee already exist with name:"+newEmployee.getName());
        }
        newEmployee.setPassword(passwordEncoder.encode((newEmployee.getPassword())));
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        employee.setIsactive(0);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Integer id, Employee newEmployee) {
        if (employeeRepository.findById(id).isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        Employee oldEmployee = getEmployeeById(id);
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setPassword(newEmployee.getPassword());
        oldEmployee.setUsername(newEmployee.getUsername());
        oldEmployee.setIsactive(newEmployee.getIsactive());
        employeeRepository.save(oldEmployee);
    }




}
