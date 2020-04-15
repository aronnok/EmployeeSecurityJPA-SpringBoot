package com.socita.Employee.repos;

import com.socita.Employee.entities.Employee;
import com.socita.Employee.entities.Salary;
import com.socita.Employee.entities.SalaryIdClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, SalaryIdClass> {

    List<Salary> findSalaryByEmployeeNumber( Long employeeNumber);
}
