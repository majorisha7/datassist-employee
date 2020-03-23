package com.datassist.spring.services;

import com.datassist.spring.models.Employee;
import com.datassist.spring.models.EmployeeRequestDTO;
import com.datassist.spring.models.EmployeeUpdateDTO;
import com.datassist.spring.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee get(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employee Not Found"));

        return employee;
    }

    @Override
    public Employee post(EmployeeRequestDTO requestDTO) {

        ModelMapper modelMapper = new ModelMapper();

        Employee employee = modelMapper.map(requestDTO, Employee.class);
        employeeRepository.insert(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee put(String id, EmployeeUpdateDTO requestDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employee Not Found"));

        employee.fromUpdateDTO(requestDTO);

        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void remove(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employee Not Found"));

        employeeRepository.deleteById(id);
    }
}
