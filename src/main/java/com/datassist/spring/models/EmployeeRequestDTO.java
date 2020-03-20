package com.datassist.spring.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequestDTO {
    private int age;

    private int childCount;

    private String citizenship;

    private String employeePhoto;

    private String employer;

    private LocalDate employmentStartDate;

    private String firstName;

    private LocalDate hireDate;

    private String lastName;

    private Gender gender;

    private Status maritalStatus;

    private String profession;

    private boolean retired;

    private BigDecimal salary;

    private String salaryCurrency;

    private String salaryPeriod;
}

