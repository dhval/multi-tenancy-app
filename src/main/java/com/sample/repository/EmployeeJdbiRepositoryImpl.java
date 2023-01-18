package com.sample.repository;

import com.sample.model.Employee;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Singleton
@ReadOnly
public class EmployeeJdbiRepositoryImpl implements EmployeeJdbiRepository {

    private final Jdbi jdbi;

    public EmployeeJdbiRepositoryImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        return jdbi.withHandle(handle -> {
            try(Query query = handle.createQuery("select * from employee")) {
                Optional<Employee> employee = query.map(
                        (rs, ctx) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3))
                ).findFirst();
                return employee;
            }
        });
    }
}
