package br.com.restaurante.service.teste;

import br.com.restaurante.dao.ClienteDao;
import br.com.restaurante.dao.EnderecoDao;
import br.com.restaurante.entity.ClienteId;
import br.com.restaurante.util.CargaDeDadosUtil;
import br.com.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class PedidoService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarPedidosClientes(entityManager);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.consultarClientes("null", "null", "lapa"));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria("null", "null", "lapa"));

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorNome("Maria"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
