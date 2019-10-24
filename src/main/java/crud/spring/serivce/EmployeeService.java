package crud.spring.serivce;

import com.mongodb.WriteResult;
import crud.spring.dao.EmployeeDAO;
import crud.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> getEmployees() {

        return employeeDAO.getEmployees();
    }

    public Employee create(Employee employee) {

        employee.setEmployeeId(UUID.randomUUID());
        employee.setCreationTime(LocalDateTime.now());

        employeeDAO.create(employee);
        return employee;
    }

    public Employee get(UUID id) {

        return employeeDAO.get(id);
    }

    public Employee update(UUID employeeId, Employee employee) {

        Employee oldEmployee = employeeDAO.get(employeeId);
        employee.setEmployeeId(oldEmployee.getEmployeeId());
        employee.setCreationTime(oldEmployee.getCreationTime());

        employeeDAO.update(employee);
        return employee;
    }

    public WriteResult delete(UUID employeeId) {

        return employeeDAO.delete(employeeId);
    }
}
