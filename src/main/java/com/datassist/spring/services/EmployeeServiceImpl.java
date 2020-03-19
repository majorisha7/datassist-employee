package com.datassist.spring.services;

import com.datassist.spring.models.Employee;
import com.datassist.spring.models.EmployeeRequestDTO;
import com.datassist.spring.models.Gender;
import com.datassist.spring.models.EmployeeUpdateDTO;
import com.datassist.spring.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee get(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found");
        }
        return employee;
    }

    @Override
    public Employee post(EmployeeRequestDTO requestDTO) {

        Employee employee = new Employee();
        employee.setFirstName(requestDTO.getFirstName());
        employee.setLastName(requestDTO.getLastName());
        employee.setAge(requestDTO.getAge());
        employee.setChildCount(requestDTO.getChildCount());
        employee.setCitizenship(requestDTO.getCitizenship());
        employee.setEmployeePhoto(requestDTO.getEmployeePhoto());
        employee.setEmployer(requestDTO.getEmployer());
        employee.setEmploymentStartDate(requestDTO.getEmploymentStartDate());
        employee.setHireDate(requestDTO.getHireDate());
        employee.setGender(requestDTO.getGender());
        employee.setSalary(requestDTO.getSalary());
        employee.setMaritalStatus(requestDTO.getMaritalStatus());
        employee.setSalaryPeriod(requestDTO.getSalaryPeriod());
        employee.setProfession(requestDTO.getProfession());
        employee.setSalaryCurrency(requestDTO.getSalaryCurrency());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employee = employeeRepository.findAll();
        return employee;
    }

    @Override
    public Employee put(String id, EmployeeUpdateDTO requestDTO) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found");


        }
        if(requestDTO.getFirstName() != null){
            employee.setFirstName(requestDTO.getFirstName());
            employee.setLastName(requestDTO.getLastName());
        }


        employee.setAge(requestDTO.getAge());
        employee.setChildCount(requestDTO.getChildCount());
        employee.setCitizenship(requestDTO.getCitizenship());
        employee.setEmployeePhoto(requestDTO.getEmployeePhoto());
        employee.setEmployer(requestDTO.getEmployer());
        employee.setEmploymentTerminationDate(requestDTO.getEmploymentTerminationDate());
        employee.setHireDate(requestDTO.getHireDate());
        employee.setGender(requestDTO.getGender());
        employee.setSalary(requestDTO.getSalary());
        employee.setMaritalStatus(requestDTO.getMaritalStatus());
        employee.setSalaryPeriod(requestDTO.getSalaryPeriod());
        employee.setProfession(requestDTO.getProfession());
        employee.setSalaryCurrency(requestDTO.getSalaryCurrency());

        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void remove(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found");
        }
        employeeRepository.deleteById(id);
    }
}
