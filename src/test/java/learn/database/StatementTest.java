package learn.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;




public class StatementTest {
    

@Test
void TestCreateStatement() throws SQLException{
   Connection connection = ConnectionUtil.getDataSource().getConnection();
   

   Statement statement = connection.createStatement();


   statement.close();

   connection.close();
}


@Test
void TestExecuteUpdate() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String query = """
            INSERT INTO users VALUES ("123", "jono");
            """;

    statement.executeUpdate(query);

    connection.close();
    statement.close();
}


@Test
void TestExecuteQuery() throws SQLException {
    String query = "SELECT * FROM users";

    // Use try-with-resources to automatically close resources
    try (Connection connection = ConnectionUtil.getDataSource().getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        fail("Database operation failed: " + e.getMessage());
    }
}


}
