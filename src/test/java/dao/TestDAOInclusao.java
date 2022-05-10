package dao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;

public class TestDAOInclusao {

    HashMapClienteDAO DAO;
    Cliente cliente;

    @Before
    public void inicializa() {
        DAO = new HashMapClienteDAO();
        cliente = new Cliente("1", "Teste", "11111111111");
    }

    @Test
    public void testIncluir() throws Exception {
        DAO.inserir(cliente);
        List lista = DAO.getLista();
        assertNotNull(lista);
    }

    @After
    public void Finaliza() throws Exception {
        DAO = null;
        cliente = null;
    }
}
