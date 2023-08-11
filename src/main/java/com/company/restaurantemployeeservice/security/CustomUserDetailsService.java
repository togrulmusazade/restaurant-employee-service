package com.company.restaurantemployeeservice.security;

import com.company.restaurantemployeeservice.entity.Employee;
import com.company.restaurantemployeeservice.exception.EmployeeNotFoundException;
import com.company.restaurantemployeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByUsername(username);
        if(employee ==null) {
            throw new UsernameNotFoundException("Employee Not Found with username: " + username );
        }
        return new CustomUserDetails(employee);
    }
}