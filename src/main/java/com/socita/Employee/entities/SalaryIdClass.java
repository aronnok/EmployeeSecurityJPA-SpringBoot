package com.socita.Employee.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
public class SalaryIdClass implements Serializable {

        private Long employeeNumber;
        private Date fromDate;

        public Long getEmployeeNumber() {
                return employeeNumber;
        }

        public void setEmployeeNumber(Long employeeNumber) {
                this.employeeNumber = employeeNumber;
        }

        public Date getFromDate() {
                return fromDate;
        }

        public void setFromDate(Date fromDate) {
                this.fromDate = fromDate;
        }
}
