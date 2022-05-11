package dao;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;

import entidade.Cliente;
import dao.cliente.*;
import java.util.List;

public class TestClienteDAOHashMap {

    private Cliente cliente = null;
    private HashMapClienteDAO clienteDAOHashMap = null;
    private String nomeTeste = "Teste";
    private String cpfTeste = "11111111111";
    private String idTeste = "1";

    @Before
    public void setUp() {
        cliente = new Cliente(idTeste, nomeTeste, cpfTeste);
        clienteDAOHashMap = new HashMapClienteDAO();
    }

    @After
    public void tearDown() {
        cliente = null;
        clienteDAOHashMap = null;
    }

    @Test
    public void testInclusao() {
        clienteDAOHashMap.inserir(cliente);
        List lista = clienteDAOHashMap.getLista();
        assertNotNull(lista);
    }

    @Test
    public void testExclusao() {
        clienteDAOHashMap.inserir(cliente);
        List lista = clienteDAOHashMap.getLista();

        if (lista.size() > 0) {
            clienteDAOHashMap.excluir(lista.get(0));
            lista = clienteDAOHashMap.getLista();
            assertTrue(lista.size() == 0);
        } else {
            assertFalse(false);
        }

    }

    @Test //Espera-se que o método inserir() trate a exceção
    public void testExcecaoIncluir() {
        try {
            boolean result = clienteDAOHashMap.inserir(null);
            assertFalse(result);
        } catch (Exception e) {
            fail("N�o tratou exceção cliente = Null");
        }

    }

    @Test(expected = NullPointerException.class) //Espera-se que o método excluir() lance a exceção
    public void testExcecaoExcluir() {
        clienteDAOHashMap.excluir(null);
    }
}
