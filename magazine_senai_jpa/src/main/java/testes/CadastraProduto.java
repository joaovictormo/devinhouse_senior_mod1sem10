package testes;

import dao.ProdutoDAO;
import models.Produto;
import models.enums.StatusProduto;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CadastraProduto {
  public static void main(String[] args) {
    Produto produto = new Produto();
    produto.setNome("Livro Angular");
    produto.setDescricao("Livro didático de Angular");
    produto.setPreco(100.0);
    produto.setQtdEstoque(10);
    produto.setDataCadastro(LocalDate.now());
    produto.setStatus(StatusProduto.PRATELEIRA);

    EntityManager em = JPAUtil.getEntityManager();

    ProdutoDAO dao = new ProdutoDAO(em);

    em.getTransaction().begin();

    dao.cadastrar(produto);

    em.getTransaction().commit();
    em.close();

  }
}
