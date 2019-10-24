package crud.spring.dao;

import com.mongodb.WriteResult;
import crud.spring.DataSourceConfig;
import crud.spring.entity.Employee;
import dev.morphia.Key;
import dev.morphia.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDAO {

    @Autowired
    private DataSourceConfig dataSourceConfig;


    public List<Employee> getEmployees() {
        return dataSourceConfig.datastore()
                .createQuery(Employee.class)
                .find()
                .toList();
    }

    public Key<Employee> create(Employee employee) {

        return dataSourceConfig.datastore()
                .save(employee);
    }

    public Employee get(UUID employeeId) {

        return dataSourceConfig.datastore()
                .createQuery(Employee.class)
                .field("_id")
                .equal(employeeId)
                .first();
    }

    public Key<Employee> update(Employee employee) {

        return dataSourceConfig.datastore()
                .save(employee);
    }

    public WriteResult delete(UUID employeeId) {

        Query<Employee> employee = dataSourceConfig.datastore()
                .createQuery(Employee.class)
                .field("_id")
                .equal(employeeId);

        return dataSourceConfig.datastore()
                .delete(employee);
    }
}
