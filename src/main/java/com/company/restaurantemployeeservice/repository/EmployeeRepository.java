package com.company.restaurantemployeeservice.repository;

import com.company.restaurantemployeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByusername(String username);

    Optional<Employee> findByName(String name);

    Employee findByUsername(String username);

}