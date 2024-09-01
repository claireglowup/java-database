package learn.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {
    
 public static HikariDataSource dataSource;

 static {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/javadatabase?serverTime=Asia/Jakarta");
    config.setUsername("root");
    config.setPassword("secret");

    config.setMinimumIdle(5);
    config.setMaximumPoolSize(10);  
    config.setIdleTimeout(60_000);
    config.setMaxLifetime(5 * 60_000);

    dataSource = new HikariDataSource(config);
 }

 public static HikariDataSource getDataSource() {
    return dataSource;
 }

}
