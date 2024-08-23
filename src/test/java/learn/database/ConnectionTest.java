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
      String  jdbcUrl = "jdbc:mysql://localhost:3306/javadatabase?serverTimezome=Asia/Jakarta";
      String  username = "root";
      String  password = "secret";
      //harus ditutup koneksinya yhh dengan connection.close();
      //bisa juga pake try with resource try () {}
      try {
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("success connect");
      }catch(SQLException e) {
        e.printStackTrace();
      }
      
    }
}
