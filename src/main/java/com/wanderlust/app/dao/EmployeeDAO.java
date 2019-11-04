package com.wanderlust.app.dao;

import com.mongodb.WriteResult;
import com.wanderlust.app.entity.Employee;
import dev.morphia.Datastore;
import dev.morphia.Key;
import dev.morphia.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDAO {

    @Autowired
    private Datastore datastore;


    public List<Employee> getEmployees() {

        return datastore
                .createQuery(Employee.class)
                .find()
                .toList();
    }

    public Key<Employee> create(Employee employee) {

        return datastore
                .save(employee);
    }

    public Employee get(UUID employeeId) {

        return datastore
                .createQuery(Employee.class)
                .field("_id")
                .equal(employeeId)
                .first();
    }

    public Key<Employee> update(Employee employee) {

        return datastore
                .save(employee);
    }

    public WriteResult delete(UUID employeeId) {

        Query<Employee> employee = datastore
                .createQuery(Employee.class)
                .field("_id")
                .equal(employeeId);

        return datastore
                .delete(employee);
    }
}
