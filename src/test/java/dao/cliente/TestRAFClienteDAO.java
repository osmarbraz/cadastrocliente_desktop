package dao.cliente;

import java.io.IOException;

import org.junit.Test;

public class TestRAFClienteDAO {

    /**
     * Testa se o arquivo não existe.
     * @throws IOException 
     */
    @Test(expected = IOException.class)
    public void testeAbrirArquivo() throws IOException {

        RAFClienteDAO instancia = new RAFClienteDAO();
        instancia.abrirArquivo("tes\\te//.txt");
    }
}
