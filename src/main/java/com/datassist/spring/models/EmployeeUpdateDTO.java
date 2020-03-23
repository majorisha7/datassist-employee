package com.datassist.spring.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeUpdateDTO {
    private Integer age;

    private Integer childCount;

    private String citizenship;

    private String employeePhoto;

    private String employer;

    private String firstName;

    private LocalDate hireDate;

    private LocalDate employmentTerminationDate;

    private String lastName;

    private Gender gender;

    private Status maritalStatus;

    private String profession;

    private Boolean retired;

    private BigDecimal salary;

    private String salaryCurrency;

    private String salaryPeriod;

}
