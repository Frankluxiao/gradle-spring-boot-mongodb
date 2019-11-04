package com.wanderlust.app.serivce;

import com.mongodb.WriteResult;
import com.wanderlust.app.dao.EmployeeDAO;
import com.wanderlust.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;


    private static final String CREATE_ERROR = "Failed to create contact";
    private static final String GET_ERROR = "Failed to get employee with Id = %s in database";
    private static final String UPDATE_ERROR = "Failed to update contact with Id = %s in database";
    private static final String DELETE_ERROR = "Failed to delete contact with Id = %s in database";


    public List<Employee> getEmployees() {

        return employeeDAO.getEmployees();
    }

    public Employee create(Employee employee) {

        employee.setEmployeeId(UUID.randomUUID());
        employee.setCreationTime(LocalDateTime.now());

        try {
            employeeDAO.create(employee);
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(CREATE_ERROR, e);
        }
    }

    public Employee get(UUID employeeId) {

        try {
            return employeeDAO.get(employeeId);
        } catch (Exception e) {
            throw new RuntimeException(format(GET_ERROR, employeeId.toString()), e);
        }
    }

    public Employee update(UUID employeeId, Employee employee) {

        try {
            Employee oldEmployee = employeeDAO.get(employeeId);
            employee.setEmployeeId(oldEmployee.getEmployeeId());
            employee.setCreationTime(oldEmployee.getCreationTime());

            employeeDAO.update(employee);
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(format(UPDATE_ERROR, employeeId.toString()), e);
        }
    }

    public WriteResult delete(UUID employeeId) {

        try {
            return employeeDAO.delete(employeeId);
        } catch (Exception e) {
            throw new RuntimeException(format(DELETE_ERROR, employeeId.toString()), e);
        }

    }
}
