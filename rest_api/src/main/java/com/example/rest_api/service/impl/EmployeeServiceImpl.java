package com.example.rest_api.service.impl;

import com.example.rest_api.entity.Employee;
import com.example.rest_api.repository.EmployeeRepository;
import com.example.rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public void setEmployeeRepo(EmployeeRepository repo) { this.employeeRepo = repo; }

    public List<Employee> getEmployeeList() { return employeeRepo.findAll(); }

    public Employee getEmployee(Long id) { return employeeRepo.findById(id).get(); }

    public Employee saveEmployee(Employee em) { return employeeRepo.save(em); }

    public void deleteEmployee(Long id) { employeeRepo.delete(getEmployee(id)); }

    public void updateEmployee(Employee em) { employeeRepo.save(em); }
}
