package com.epam.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private boolean external;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "personal_info")
    private EmployeePersonalInfo employeePersonalInfo;

    @Embedded
    private Personal personal;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;

    @ManyToMany
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "employee_unit")
    private Unit unit;

}
