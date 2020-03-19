package com.datassist.spring.services;

import com.datassist.spring.models.Employee;
import com.datassist.spring.models.EmployeeRequestDTO;
import com.datassist.spring.models.EmployeeUpdateDTO;

import java.util.List;


public interface EmployeeService {
    Employee get(String id);

    Employee post(EmployeeRequestDTO requestDTO);

    List<Employee> getAll();

    Employee put(String id, EmployeeUpdateDTO requestDTO);

    void remove(String id);
}
