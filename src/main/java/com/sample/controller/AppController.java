package com.sample.controller;

import com.sample.model.Employee;
import com.sample.repository.EmployeeJdbiRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/hello")
public class AppController {

    @Inject
    EmployeeJdbiRepository employeeJdbiRepository;

    @Get("/{empId}")
    public Optional<Employee> getEmployee(int empId) {
        return employeeJdbiRepository.getEmployee(empId);
    }

}
