package br.com.restaurante.service.teste;

import br.com.restaurante.dao.CardapioDao;
import br.com.restaurante.util.CargaDeDadosUtil;
import br.com.restaurante.util.JPAUtil;
import javax.persistence.EntityManager;

public class CardapioService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);

//      System.out.println("Lista de produtos por valor: " +cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
//      System.out.println("Lista de produtos por nome: " +cardapioDao.consultarPorNome("bruschetta"));

        entityManager.close();
    }
}
