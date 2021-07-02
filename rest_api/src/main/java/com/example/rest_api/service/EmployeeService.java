package com.example.rest_api.service;

import com.example.rest_api.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Optional<Employee> getEmployee(Long id);

    Employee saveEmployee(Employee em);

    void deleteEmployee(Long id);

    void updateEmployee(Employee em);
}
