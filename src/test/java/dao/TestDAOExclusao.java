package dao;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

public class TestDAOExclusao {

    Cliente cliente;

    @Before
    public void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    @Test
    public void testExclusao1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();;
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
    public void testExclusao1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.excluir(null));
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
    public void testExclusao2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.excluir(null));
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

    @Test
    public void testExclusao3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.excluir(null));
    }

    @After
    public void Finaliza() throws Exception {
        cliente = null;
    }
}
