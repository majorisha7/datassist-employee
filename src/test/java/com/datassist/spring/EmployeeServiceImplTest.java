package com.datassist.spring;

import com.datassist.spring.models.Employee;
import com.datassist.spring.models.EmployeeUpdateDTO;
import com.datassist.spring.repositories.EmployeeRepository;
import com.datassist.spring.services.EmployeeService;
import com.datassist.spring.services.EmployeeServiceImpl;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceImplTest {

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void whenGetAllEmployeesThanReturnNotException() {
        // Arrange
        Employee emp = prepareEmployee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp);
        when(employeeRepository.findAll()).thenReturn(employeeList);

        // Act
        List<Employee> responseList = employeeService.getAll();

        // Assert
        Assert.assertEquals(1, responseList.size());
        softly.assertThat(responseList.size()).isEqualTo(employeeList.size());
        softly.assertThat(responseList.get(0).getFirstName()).isEqualTo(emp.getFirstName());
    }

    @Test
    public void InvalidParamsWhenPutEmployeeThanShouldThrownException() {
        // Arrange
        EmployeeUpdateDTO updateDTO = new EmployeeUpdateDTO();
        updateDTO.setFirstName("qwe");
        Employee employee = prepareEmployee();
        when(employeeRepository.findById("1234")).thenReturn(Optional.of(employee));
        thrown.expect(ResponseStatusException.class);
        thrown.expectMessage("Employee Not Found");

        // Act
        employeeService.put("123", updateDTO);

    }

    @Test
    public void givenValidParamsWhenPutEmployeeThenReturnNotThrown() {
        EmployeeUpdateDTO updateDTO = new EmployeeUpdateDTO();
        updateDTO.setFirstName("bb");
        updateDTO.setLastName("cc");
        updateDTO.setAge(25);
        Employee employee = prepareEmployee();
        when(employeeRepository.findById("123")).thenReturn(Optional.of(employee));

        Employee response =  employeeService.put("123", updateDTO);
        softly.assertThat(response.getFirstName()).isEqualTo(updateDTO.getFirstName());
        softly.assertThat(response.getAge()).isEqualTo(updateDTO.getAge());
        softly.assertThat(response.getLastName()).isEqualTo(updateDTO.getLastName());
    }

    private Employee prepareEmployee() {
        Employee emp = new Employee();
        emp.setId("123");
        emp.setLastName("dssf");
        emp.setFirstName("aa");
        emp.setAge(15);
        emp.setRetired(true);
        return emp;
    }
}