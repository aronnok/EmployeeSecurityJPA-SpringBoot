package com.socita.Employee;

import com.socita.Employee.repos.DepartmentRepo;
import com.socita.Employee.repos.EmployeeRepo;
import com.socita.Employee.repos.SalaryRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    SalaryRepo salaryRepo;

    @Test
    public void shouldReturnTenEntries(){
        assertEquals((employeeService.findAll(10)).size(),10);
    }


    @Test
    public void shouldReturnValidEmployeeDTO() throws ParseException {

        EmployeeDTO employeeDTO = employeeService.getEmploee(10001L);

        assertEquals(employeeDTO.getFirstName(),"Georgi");
        assertEquals(employeeDTO.getLastName(),"Facello");
        assertEquals(employeeDTO.getCurrentDepartmentNumber(),"d005");
        assertEquals( employeeDTO.getSalaryHistory().size(),17);


    }

}
