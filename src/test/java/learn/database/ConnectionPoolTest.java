package learn.database;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolTest {
    

    @Test
    void testHikariCp() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/javadatabase?serverTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("secret");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);                                 

        HikariDataSource dataSource = new HikariDataSource(config);
        try {
            dataSource.getConnection();
            System.out.println("connection success");         
        } catch (Exception e) {
            e.printStackTrace();        
        }
    }
}
