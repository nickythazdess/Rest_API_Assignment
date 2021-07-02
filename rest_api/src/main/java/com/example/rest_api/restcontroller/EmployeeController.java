package com.example.rest_api.restcontroller;

import com.example.rest_api.entity.Employee;
import com.example.rest_api.exceptions.EmployeeExceptions;
import com.example.rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable Long id) {
        Employee emp = employeeService.getEmployee(id);
        if (emp != null) return emp;
        else throw new EmployeeExceptions(id);
    }

    @PostMapping()
    public Employee saveEmployee(@Valid @RequestBody Employee em) { return employeeService.saveEmployee(em); }

    @PutMapping()
    public HashMap<String, String> updateEmployee(@Valid @RequestBody Employee employeeUpdate) {
        employeeService.updateEmployee(employeeUpdate);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Update successfully!");
        return map;
    }

    @DeleteMapping("/{id}")
    public HashMap<String, String> deleteEmployee(@PathVariable Long id) {
        this.findEmployee(id);
        employeeService.deleteEmployee(id);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Delete successfully!");
        return map;
    }
}
