package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
    private final String url;
    private final String login;
    private final String password;

    public MyConnect(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Connection connectWizard() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
}
