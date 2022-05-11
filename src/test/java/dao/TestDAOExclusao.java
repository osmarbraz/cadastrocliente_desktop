package dao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class TestDAOExclusao {

    Cliente cliente;

    @Before
    public void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    @Test
    public void testExclusao1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);        
        ClienteDAO DAO = factory.getClienteDAO();        ;
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            DAO.excluir(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            assertEquals(0, lista.size());
        } else {
            assertFalse(false);
        }
    }

    @Test
    public void testExclusao2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            DAO.excluir(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            assertEquals(0, lista.size());
        } else {
            assertFalse(false);
        }
    }

    @Test
    public void testExclusao3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            DAO.excluir(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            assertEquals(0, lista.size());
        } else {
            assertFalse(false);
        }
    }

    @After
    public void Finaliza() throws Exception {
        cliente = null;
    }
}
