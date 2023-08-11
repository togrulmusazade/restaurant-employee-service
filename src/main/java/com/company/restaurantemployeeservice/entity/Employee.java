package com.company.restaurantemployeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer  iduserinsert = 1;
    @CreationTimestamp
    private Date insertdate;
    private Integer isactive = 1;
    @Basic(optional=false)
    private String name;
    @Basic(optional=false)
    private String password;
    private String surname;
    @Basic(optional=false)
    private String username;
    private String role = "USER";


}