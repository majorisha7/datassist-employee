package com.datassist.spring.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

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

    private BigDecimal salary;

    private String salaryCurrency;

    private String salaryPeriod;

    public Employee fromUpdateDTO(EmployeeUpdateDTO dto) {
        firstName = Optional.ofNullable(dto.getFirstName()).orElse(this.firstName);
        lastName = Optional.ofNullable(dto.getLastName()).orElse(this.lastName);
        age = dto.getAge() == 0 ? this.age : dto.getAge();
        childCount = dto.getChildCount() == 0 ? this.age : dto.getChildCount();
        citizenship = Optional.ofNullable(dto.getCitizenship()).orElse(this.citizenship);
        employeePhoto = Optional.ofNullable(dto.getEmployeePhoto()).orElse(this.employeePhoto);
        employer = Optional.ofNullable(dto.getEmployer()).orElse(this.employer);
        hireDate = Optional.ofNullable(dto.getHireDate()).orElse(this.getHireDate());
        gender = Optional.ofNullable(dto.getGender()).orElse(this.gender);
        maritalStatus = Optional.ofNullable(dto.getMaritalStatus()).orElse(this.maritalStatus);
        profession = Optional.ofNullable(dto.getProfession()).orElse(this.profession);
        salary = Optional.ofNullable(dto.getSalary()).orElse(this.salary);
        salaryCurrency = Optional.ofNullable(dto.getSalaryCurrency()).orElse(this.salaryCurrency);
        salaryPeriod = Optional.ofNullable(dto.getSalaryPeriod()).orElse(this.salaryPeriod);
        retired = Optional.of(dto.isRetired()).orElse(this.retired);
        return this;
    }

}