package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {
    Connection connection;
    Statement statement;

    public Con() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "majdkenza11*");
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
