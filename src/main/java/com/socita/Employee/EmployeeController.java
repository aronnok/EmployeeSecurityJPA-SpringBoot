package com.socita.Employee;

import com.socita.Employee.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path="/employees")
    public List<Employee> getAllEmployee(){

        List<Employee> employeeList = employeeService.findAll(10);
        logger.info("Listing first ten employees : {}",employeeList);
        return employeeList;

    }

    @GetMapping(path="/employees/{employeeNumber}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeNumber) throws ParseException {

        logger.info("Getting employee info by employeeNumber : {}", employeeNumber);
        EmployeeDTO employeeDTO = employeeService.getEmploee(employeeNumber);
        logger.info("Found EmployeeDTO : {}", employeeDTO);

        return employeeDTO;
    }

}
