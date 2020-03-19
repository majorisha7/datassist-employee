package com.datassist.spring.controllers;

import com.datassist.spring.models.Employee;
import com.datassist.spring.models.EmployeeRequestDTO;
import com.datassist.spring.models.EmployeeUpdateDTO;
import com.datassist.spring.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = ("/employees"))
@AllArgsConstructor

public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping(value = "/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(
            @PathVariable("employeeId") String id) {
        return employeeService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee postEmployee(
            @RequestBody EmployeeRequestDTO requestDTO) {
        return employeeService.post(requestDTO);
    }

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> listEmployee(){
        return employeeService.getAll();
    }

    @PutMapping(value = "/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee putEmployee(
            @PathVariable("employeeId") String id,  @RequestBody EmployeeUpdateDTO requestDTO) {
        return employeeService.put(id, requestDTO);
    }

    @DeleteMapping(value = "/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(
            @PathVariable("employeeId") String id){
        employeeService.remove(id);
    }



}