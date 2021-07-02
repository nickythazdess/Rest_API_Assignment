package com.example.rest_api.exceptions;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeCustomExceptionHandler {
    private String prepareErrorJSON(HttpStatus status, Exception ex) {
        JSONObject errorJSON = new JSONObject();
        try {
            errorJSON.put("status", status.value());
            errorJSON.put("error", status.getReasonPhrase());
            errorJSON.put("message", ex.getMessage().split(":")[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return errorJSON.toString();
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundException(EmployeeNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(prepareErrorJSON(status, ex), status);
    }
}
