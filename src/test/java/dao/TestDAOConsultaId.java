package dao;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class TestDAOConsultaId {

    Cliente cliente;

    @Before
    public void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    @Test
    public void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    public void testConsulta1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        //Consulta
        List lista = DAO.aplicarFiltro(null);
        assertNull(lista);
    }

    @Test
    public void testConsulta2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    public void testConsulta2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        //Consulta
        List lista = DAO.aplicarFiltro(null);
        assertNull(lista);
    }

    @Test
    public void testConsulta3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    public void testConsulta3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        //Consulta
        List lista = DAO.aplicarFiltro(null);
        assertNull(lista);
    }

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
