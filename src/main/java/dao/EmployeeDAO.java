package dao;


import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee getEmployee(int id) throws SQLException;

    List<Employee> allEmployee() throws SQLException;

    Employee update(int id);

    void remove(int id);
}

