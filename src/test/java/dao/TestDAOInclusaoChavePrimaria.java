package dao;

import dao.cliente.*;
import entidade.Cliente;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class TestDAOInclusaoChavePrimaria {

    Cliente cliente;

    @Before
    public void inicializa() {
        cliente = new Cliente("123", "Teste Chave Primaria", "11111111111");
    }

    @Test
    public void testIncluir1() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados        
        DAO.inserir(cliente);
        // Repete a inserção dos dados
        assertFalse(DAO.inserir(cliente));        
    }
    
    
    @Test
    public void testIncluir2() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados                           
        DAO.inserir(cliente);
        // Repete a inserção dos dados
        assertFalse(DAO.inserir(cliente));        
    }

    @Test
    public void testIncluir3() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        // Insere os dados        
        DAO.inserir(cliente);
         // Repete a inserção dos dados
        assertFalse(DAO.inserir(cliente));        
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
