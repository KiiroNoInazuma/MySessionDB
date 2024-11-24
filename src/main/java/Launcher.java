import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.MyConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/wizard";
        final String user = "admin";
        final String password = "*****";

        MyConnect myConnect = new MyConnect(url, user, password);

        try (Connection connection = myConnect.connectWizard()) {
            EmployeeDAO employee = new EmployeeDAOImpl(myConnect);
            System.out.println(employee.getEmployee(1));
            System.out.println(employee.allEmployee().toString());
            System.out.println(connection.getCatalog());
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }
}
