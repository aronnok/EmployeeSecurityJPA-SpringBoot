package com.socita.Employee.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employees")
@ToString
@Data
public class Employee {

    @Id
    @Column(name = "emp_no")
    private Long employeeNumber;
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gemder;

    @Column(name = "hire_date")
    private String hireDate;


}
