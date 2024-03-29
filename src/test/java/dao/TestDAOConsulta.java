package dao;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

public class TestDAOConsulta {

    Cliente cliente;

    /**
     * Instância um cliente para os testes.
     */
    @Before
    public void inicializa() {
        cliente = new Cliente("131", "Cliente Existente", "11111111111");
    }

    /**
     * Testa um cliente existente no SQLite.
     */
    @Test
    public void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.getLista();
        assertNotEquals(0, lista.size());
    }

    /**
     * Testa um cliente existente no Hashmap.
     */
    @Test
    public void testConsulta2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.getLista();

        assertNotEquals(0, lista.size());
    }

    /**
     * Testa um cliente existente no RAF.
     */
    @Test
    public void testConsulta3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.getLista();

        assertNotEquals(0, lista.size());
    }

    /**
     * Exclui os clientes usados nos testes.
     *
     * @throws java.lang.Exception
     */
    @After
    public void Finaliza() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        cliente = null;
    }
}
