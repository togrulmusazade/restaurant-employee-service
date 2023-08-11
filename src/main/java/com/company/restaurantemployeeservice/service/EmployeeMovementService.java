package com.company.restaurantemployeeservice.service;

import com.company.restaurantemployeeservice.entity.EmployeeMovement;
import com.company.restaurantemployeeservice.exception.EmployeeMovementNotFoundException;
import com.company.restaurantemployeeservice.repository.EmployeeMovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeMovementService {

    private final EmployeeMovementRepository employeeMovementRepository;

    public List<EmployeeMovement> getEmployeeMovements(){
            return employeeMovementRepository.findAll();
    }


    public EmployeeMovement getEmployeeMovementById(Integer id) {
        return employeeMovementRepository.findById(id)
                .orElseThrow(() -> new EmployeeMovementNotFoundException("EmployeeMovement not found with id: " + id));
    }


    public EmployeeMovement createEmployeeMovement(EmployeeMovement newEmployeeMovement) {
        return employeeMovementRepository.save(newEmployeeMovement);
    }

    public void deleteEmployeeMovement(Integer id) {
        EmployeeMovement employeeMovement = employeeMovementRepository.findById(id)
                .orElseThrow(() -> new EmployeeMovementNotFoundException("EmployeeMovement not found with id: " + id));
        employeeMovement.setIsactive(0);
        employeeMovementRepository.save(employeeMovement);
    }

    public void updateEmployeeMovement(Integer id, EmployeeMovement newEmployeeMovement) {
        if (employeeMovementRepository.findById(id).isEmpty()){
            throw new EmployeeMovementNotFoundException("EmployeeMovement not found with id: " + id);
        }
        EmployeeMovement oldEmployeeMovement = getEmployeeMovementById(id);
        oldEmployeeMovement.setExitdate(newEmployeeMovement.getExitdate());
        oldEmployeeMovement.setEnterdate(newEmployeeMovement.getEnterdate());
        oldEmployeeMovement.setIdemployee(newEmployeeMovement.getIdemployee());
        oldEmployeeMovement.setIsactive(newEmployeeMovement.getIsactive());
        employeeMovementRepository.save(oldEmployeeMovement);
    }



}
