package com.socita.Employee.repos;

import com.socita.Employee.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {


    public Department getDepartmentsByEmployeeIdAndToDateAfter(Long employeeNumber, Date afterToDate);
}
