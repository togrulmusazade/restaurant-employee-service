package com.company.restaurantemployeeservice.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employeemovement")
public class EmployeeMovement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Date enterdate;
    private Date exitdate;
    private Integer iduserinsert = 1;
    @CreationTimestamp
    private Date insertdate;
    private Integer isactive = 1;
    @Basic(optional=false)
    private Integer idemployee;


}