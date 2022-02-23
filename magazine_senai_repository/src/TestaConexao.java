import java.sql.*;

public class TestaConexao {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/magazine_senai";
    //String url = "jdbc:postgresql:magazine_senai";
    String user = "postgres";
    String password = "root";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      Statement statement = connection.createStatement();
      statement.execute("SELECT id, nome, descricao FROM produtos");
      ResultSet result = statement.getResultSet();
      while (result.next()) {
        int id = result.getInt(1);
        String nome = result.getString(2);
        String descricao = result.getString(3);
        System.out.printf("ID: %d; Nome: %s; Descrição: %s.%n", id, nome, descricao);
      }

    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }

  }
}
