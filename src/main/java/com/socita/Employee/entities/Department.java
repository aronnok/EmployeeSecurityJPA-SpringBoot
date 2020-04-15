package com.socita.Employee.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="dept_emp")
@ToString
@Data
public class Department {

        @Id
        @Column(name = "emp_no")
        private Long employeeId;

        @Column(name = "dept_no")
        private String departmentNumber;


        @Column(name = "from_date")
        private Date fromDate;


        @Column(name = "to_date")
        private Date toDate;



}
