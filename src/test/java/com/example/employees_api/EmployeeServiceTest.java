package com.example.employees_api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void shouldReturnAllEmployees() {
        List<Employee> mockEmployees = List.of(
                new Employee("Alice", 55000, "ENGINEERING"),
                new Employee("Bob", 72000, "SALES")
        );

        when(employeeRepository.findAll()).thenReturn(mockEmployees);

        List<Employee> result = employeeService.getEmployees();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void shouldGetEmployeeById() {
        Employee mockEmployee = new Employee("Alice", 55000, "ENGINEERING");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(mockEmployee));

        Employee result = employeeService.getEmployeeById(1L);
        assertEquals("Alice", result.getName());
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {
        when(employeeRepository.findById(88L)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class , () -> employeeService.getEmployeeById(88L));
    }
}