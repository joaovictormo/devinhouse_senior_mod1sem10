import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MagazineSenaiRepository {
  public static void main(String[] args) throws SQLException {
    ConnectionFactory factory = new ConnectionFactory();
    Connection conn = factory.getConexao();

    Statement statement = conn.createStatement();

    /*statement.execute("INSERT INTO produtos (nome, descricao, preco, qtd_estoque) " +
            "VALUES" +
            "('Curso Java', 'Curso introdutório da linguagem Java', 1000, 50)," +
            "('Livro SpringBoot', 'Livro didático SpringBoot', 100, 30)",
        Statement.RETURN_GENERATED_KEYS);

    ResultSet result = statement.getGeneratedKeys();
    while (result.next()) {
      int id = result.getInt(1);
      System.out.printf("ID gerado: %d.%n", id);
    }*/

    statement.execute("DELETE FROM produtos WHERE id > 3 AND nome = 'Curso Java'");
    int registrosModificados = statement.getUpdateCount();

    System.out.printf("Foram deletados %d registros.%n", registrosModificados);
  }
}
