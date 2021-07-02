package com.example.rest_api.exceptions;

public class EmployeeExceptions extends RuntimeException {
    public EmployeeExceptions(Long id) { super("Could not find employee with id = " +id); }
}
