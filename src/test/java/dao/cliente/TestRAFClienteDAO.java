package dao.cliente;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestRAFClienteDAO {
   
    /**
     * Testa se o arquivo não existe.
     *
     */
    @Test
    public void testAbrirArquivo() {
        RAFClienteDAO rafclientedao = new RAFClienteDAO();
        assertFalse(rafclientedao.abrirArquivo("tes\\te//.txt"));
    }
}