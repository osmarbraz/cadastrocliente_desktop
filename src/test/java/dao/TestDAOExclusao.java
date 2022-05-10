package dao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;

public class TestDAOExclusao {

    HashMapClienteDAO DAO;
    Cliente cliente;

    @Before
    public void inicializa() {
        DAO = new HashMapClienteDAO();
        cliente = new Cliente("1", "Teste", "11111111111");
    }

    @Test
    public void testExclusao() {
        DAO.inserir(cliente);
        List lista = DAO.getLista();

        if (lista.size() > 0) {
            DAO.excluir(lista.get(0));
            lista = DAO.getLista();
            assertTrue(lista.size() == 0);
        } else {
            assertFalse(false);
        }
    }

    @After
    public void Finaliza() throws Exception {
        DAO = null;
        cliente = null;
    }
}
