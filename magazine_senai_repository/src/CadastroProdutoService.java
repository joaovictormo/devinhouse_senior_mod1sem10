public class CadastroProdutoService {

  private ProdutoDAO dao;

  public CadastroProdutoService(ProdutoDAO dao) {
    this.dao = dao;
  }

  public void cadastraProduto(Produto produto) {
    //regras de negócio

    this.dao.cadastrar(produto);
  }

}
