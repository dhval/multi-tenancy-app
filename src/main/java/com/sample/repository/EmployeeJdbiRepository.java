package com.sample.repository;

import com.sample.model.Employee;

import java.util.Optional;

public interface EmployeeJdbiRepository {
    Optional<Employee> getEmployee(int id);
}
