package dao.cliente;

import java.io.IOException;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

import org.junit.Test;

public class TestRAFClienteDAO {

     private RAFClienteDAO rafclientedao = null;

    /**
     * Instância uma classe de validação.
     */
    @Before
    public void inicializa() {
        rafclientedao = new RAFClienteDAO();
    }
    
    /**
     * Testa se o arquivo não existe.
     *
     */
    @Test
    public void testAbrirArquivo() {

        assertFalse(rafclientedao.abrirArquivo("tes\\te//.txt"));
    }
             
    /**
     * Finaliza a classe de RAF.
     */
    @After
    public void finaliza() {
        rafclientedao = null;
    }
}
