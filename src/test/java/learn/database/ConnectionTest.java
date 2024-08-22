package learn.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConnectionTest {
    

    @BeforeAll
    static void DriverConnect() {
        try {
            Driver sqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(sqlDriver);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    void Connection() {
      String  jdbcUrl = "jdbc:mysql://localhost:3306/javadatabase";
      String  username = "root";
      String  password = "secret";
      try {
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("success connect");
      }catch(SQLException e) {
        e.printStackTrace();
      }
      
    }
}
