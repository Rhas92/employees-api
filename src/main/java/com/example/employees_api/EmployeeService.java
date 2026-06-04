package com.example.employees_api;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee,Long id) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee " + id + " deleted";
    }
}