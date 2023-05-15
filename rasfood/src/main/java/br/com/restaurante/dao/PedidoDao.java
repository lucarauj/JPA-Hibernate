package br.com.restaurante.dao;

import br.com.restaurante.entity.Pedido;
import br.com.restaurante.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDao {

    private EntityManager entityManager;

    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    public Pedido consultarPorId(final Integer id) {
        return this.entityManager.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos() {
        String jpql = "SELECT p FROM Pedido p";
        return this.entityManager.createQuery(jpql, Pedido.class).getResultList();
    }

    public Pedido joinFetchCliente(final Integer id) {
        String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
        return this.entityManager.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
    }

    public List<ItensPrincipaisVo> consultarItensMaisVendidos() {
        String jpql = "SELECT new br.com.restaurante.vo.ItensPrincipaisVo(c.nome, SUM(pc.quantidade)) FROM Pedido p " +
                "JOIN PedidosCardapio pc on p.id = pc.cardapio.id " +
                "JOIN pc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(pc.quantidade) DESC";
        return this.entityManager.createQuery(jpql, ItensPrincipaisVo.class).getResultList();
    }

    public void atualizar(final Pedido pedido) {
        this.entityManager.merge(pedido);
    }

    public void excluir(final Pedido pedido) {
        this.entityManager.remove(pedido);
    }
}
