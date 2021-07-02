package com.example.rest_api.service;

import com.example.rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee em);

    void deleteEmployee(Long id);

    void updateEmployee(Employee em);
}
