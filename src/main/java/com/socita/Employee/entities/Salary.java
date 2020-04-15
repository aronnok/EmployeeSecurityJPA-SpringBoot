package com.socita.Employee.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="salaries")
@IdClass(SalaryIdClass.class)
@ToString
@Data
public class Salary {

        @Id
        @Column(name = "emp_no")
        private Long employeeNumber;

        @Column(name = "salary")
        private Long salary;

        @Id
        @Column(name = "from_date")
        private Date fromDate;

        @Column(name = "to_date")
        private String toDate;



}
