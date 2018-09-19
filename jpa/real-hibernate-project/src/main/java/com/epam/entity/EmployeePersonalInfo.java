package com.epam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employeePersonalInfo")
public class EmployeePersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private Integer salary;

    @OneToOne(mappedBy = "employeePersonalInfo")
    private Employee employee;
}
