import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  private final String url = "jdbc:postgresql://localhost:5432/magazine_senai";
  private final String user = "postgres";
  private final String password = "root";

  public Connection getConexao() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }
}
