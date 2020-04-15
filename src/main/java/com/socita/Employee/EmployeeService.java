package com.socita.Employee;

import com.socita.Employee.entities.Department;
import com.socita.Employee.entities.Employee;
import com.socita.Employee.entities.Salary;
import com.socita.Employee.repos.DepartmentRepo;
import com.socita.Employee.repos.EmployeeRepo;
import com.socita.Employee.repos.SalaryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    SalaryRepo salaryRepo;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Employee> findAll(Integer pageLimit){

        Pageable limit = PageRequest.of(0,pageLimit);

        logger.info("Finding employee list in service layer " );
        List<Employee> employeeList = employeeRepo.findAll(limit).toList();

        return employeeList;
    }

    public EmployeeDTO getEmploee(Long employeeNumber) throws ParseException {


        EmployeeDTO employeeDepartmentAndSalaryHistory = new EmployeeDTO();
        Employee employee =  employeeRepo.getOne(employeeNumber);
        logger.info("Found employee with employeeNumber:{}",employee );


        Date currentlyEmployedInTheDepartment =  new SimpleDateFormat("yyyy-MM-dd").parse("9998-12-31");
      //  List<Long> ids = Arrays.asList(employee.getEmployeeNumber());
        List<Salary> salaryList = salaryRepo.findSalaryByEmployeeNumber (employeeNumber);
        logger.info("Found salarylist:{}", salaryList );
        Department employeeDepartment = departmentRepo.getDepartmentsByEmployeeIdAndToDateAfter(
                    employeeNumber, currentlyEmployedInTheDepartment );

        logger.info("Found current department:{}", currentlyEmployedInTheDepartment );


        employeeDepartmentAndSalaryHistory.setEmployeeNumber(employee.getEmployeeNumber());
        employeeDepartmentAndSalaryHistory.setFirstName(employee.getFirstName());
        employeeDepartmentAndSalaryHistory.setLastName(employee.getLastName());
        employeeDepartmentAndSalaryHistory.setCurrentDepartmentNumber(
                    employeeDepartment.getDepartmentNumber());
        employeeDepartmentAndSalaryHistory.setSalaryHistory(salaryList);

        logger.info("Sending back the DTO:{}", employeeDepartmentAndSalaryHistory );

        return employeeDepartmentAndSalaryHistory;
    }
}
