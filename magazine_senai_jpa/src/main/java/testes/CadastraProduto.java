package testes;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import models.Categoria;
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
    produto.setNome("Livro Angular2");
    produto.setDescricao("Livro didático de Angular2");
    produto.setPreco(100.0);
    produto.setQtdEstoque(10);
    produto.setDataCadastro(LocalDate.now());
    produto.setStatus(StatusProduto.PRATELEIRA);

    Categoria categoria = new Categoria("LIVRO");

    EntityManager em = JPAUtil.getEntityManager();

    ProdutoDAO produtoDAO = new ProdutoDAO(em);
    CategoriaDAO categoriaDAO = new CategoriaDAO(em);

    em.getTransaction().begin();

    categoriaDAO.cadastrar(categoria);
    categoria.setNome("APOSTILA");
    em.flush();

    produto.setCategoria(categoria);

    produtoDAO.cadastrar(produto);

    em.clear();

    produto.setPreco(10);
    em.flush();

    produtoDAO.atualizar(produto);

    Produto produtoEncontrado = em.find(Produto.class, 23L);
    produtoEncontrado.setStatus(StatusProduto.FALTA);

    Produto produtoParaExcluir = em.find(Produto.class, 41L);

    Long id = 41L;
    produtoDAO.excluirPeloId(id);

    em.getTransaction().commit();

    // System.out.println(produto.getPreco());
  }
}
