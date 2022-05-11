package dao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class TestDAOAlteracao {

    Cliente cliente;
    Cliente clienteNaoExistente;

    @Before
    public void inicializa() {
        cliente = new Cliente("131", "TesteAlteracao", "11111111111");
        clienteNaoExistente = new Cliente("879", "Cliente Nao Existente", "11111111111");
    }

    @Test
    public void testAlteracao1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            DAO.alterar(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }
    
    @Test
    public void testAlteracao1NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, DAO.alterar(clienteNaoExistente));   
    }

    @Test
    public void testAlteracao1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.alterar(null));
    }

    @Test
    public void testAlteracao2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            DAO.alterar(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }
    
    @Test
    public void testAlteracao2NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, DAO.alterar(clienteNaoExistente));   
    }

    @Test
    public void testAlteracao2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.alterar(null));
    }

    @Test
    public void testAlteracao3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            DAO.alterar(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }
    
    @Test
    public void testAlteracao3NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, DAO.alterar(clienteNaoExistente));   
    }

    @Test
    public void testAlteracao3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        assertEquals(0, DAO.alterar(null));
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
