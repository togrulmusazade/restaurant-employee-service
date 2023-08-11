package com.company.restaurantemployeeservice.repository;

import com.company.restaurantemployeeservice.entity.EmployeeMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMovementRepository extends JpaRepository<EmployeeMovement, Integer> {

}