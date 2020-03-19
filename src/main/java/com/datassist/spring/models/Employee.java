package com.datassist.spring.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;

    private int age;

    private int childCount;

    private String citizenship;

    private String employeePhoto;

    private String employer;

    @NotNull(message = "Employment Start Date must not be null")
    private LocalDate employmentStartDate;

    private LocalDate employmentTerminationDate;

    @NotNull(message = "Employee's first name must not be null")
    private String firstName;

    private LocalDate hireDate;

    @NotNull(message = "Employee's last name must not be null")
    private String lastName;

    private Gender gender;

    private Status maritalStatus;

    private String profession;

    private boolean retired;

    private int salary;

    private String salaryCurrency;

    private String salaryPeriod;


}