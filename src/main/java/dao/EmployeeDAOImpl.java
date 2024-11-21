package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final MyConnect myConnect;

    public EmployeeDAOImpl(MyConnect myConnect) {
        this.myConnect = myConnect;
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public Employee getEmployee(int id) throws SQLException {
        Employee employee;
        try (Connection connection = myConnect.connectWizard()) {
            final PreparedStatement statement = connection.prepareStatement("select * from employee where id = (?)");
            statement.setMaxRows(1);
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            final String name = resultSet.getString(2);
            final String secondName = resultSet.getString(3);
            final char gender = resultSet.getString(4).charAt(0);
            final String city = resultSet.getString(6);
            employee = new Employee(name, secondName, gender, city);
        }
        return employee;
    }

    @Override
    public List<Employee> allEmployee() throws SQLException {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = myConnect.connectWizard()) {
            final PreparedStatement statement = connection.prepareStatement("select * from employee");
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                final String name = resultSet.getString(2);
                final String secondName = resultSet.getString(3);
                final char gender = resultSet.getString(4).charAt(0);
                final String city = resultSet.getString(6);
                list.add(new Employee(name, secondName, gender, city));
            }
        }
        return list;
    }

    @Override
    public Employee update(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
