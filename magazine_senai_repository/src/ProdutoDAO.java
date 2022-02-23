import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

  private Connection connection;

  public ProdutoDAO(Connection connection) {
    this.connection = connection;
  }

  public void cadastrar(Produto produto) {
    String sql = "INSERT INTO produtos (nome, descricao, preco) VALUES (?,?,?)";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPreco());

        ps.execute();
        ps.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

}
